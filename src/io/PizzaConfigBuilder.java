package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.PizzaConfig;
import model.OptionSet;

/**
 * The PizzaConfigBuilder reads a flat-file configuration for a pizzeria
 * and builds a PizzaConfig object from it.
 *
 * The file format is expected to be as follows:
 *
 *   Pizzeria: Pizza Palace
 *   BasePrice: 1600.0
 *   PizzaConfig: Deluxe Pizza
 *   OptionSet: Size
 *   Option: Small,0.0
 *   Option: Medium,250.0
 *   Option: Large,500.0
 *   OptionSet: Toppings
 *   Option: Pepperoni,200.0
 *   Option: Mushrooms,150.0
 *   Option: Onions,100.0
 *
 * Lines starting with '#' are treated as comments and skipped.
 *
 * The file is read in one pass, and objects are constructed on-the-fly.
 */
public class PizzaConfigBuilder {

    /**
     * Reads the specified configuration file and builds a PizzaConfig object.
     *
     * @param filename the configuration file path
     * @return a PizzaConfig object based on the file contents, or null if not built
     * @throws IOException if an I/O error occurs
     */
    public static PizzaConfig buildPizzaConfig(String filename) throws IOException {
        PizzaConfig pizzaConfig = null;
        ArrayList<OptionSet> optionSets = new ArrayList<>();
        OptionSet currentOptionSet = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                // Skip empty lines and comments
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                if (line.startsWith("Pizzeria:")) {
                    // Currently, we might not use this value directly.
                    // String pizzeriaName = line.substring("Pizzeria:".length()).trim();
                    // Could be stored or used as needed.
                } else if (line.startsWith("BasePrice:")) {
                    double basePrice = Double.parseDouble(line.substring("BasePrice:".length()).trim());
                    if (pizzaConfig != null) {
                        pizzaConfig.setBasePrice(basePrice);
                    }
                } else if (line.startsWith("PizzaConfig:")) {
                    String configName = line.substring("PizzaConfig:".length()).trim();
                    pizzaConfig = new PizzaConfig(configName);
                } else if (line.startsWith("OptionSet:")) {
                    String optionSetName = line.substring("OptionSet:".length()).trim();
                    currentOptionSet = new OptionSet(optionSetName);
                    optionSets.add(currentOptionSet);
                } else if (line.startsWith("Option:")) {
                    if (currentOptionSet == null) {
                        System.err.println("Option defined before an OptionSet!");
                        continue;
                    }
                    String optionData = line.substring("Option:".length()).trim();
                    String[] parts = optionData.split(",");
                    if (parts.length == 2) {
                        String optionName = parts[0].trim();
                        double price = Double.parseDouble(parts[1].trim());
                        currentOptionSet.addOption(currentOptionSet.new Option(optionName, price));
                    } else {
                        System.err.println("Invalid option format: " + line);
                    }
                }
            }
        }
        // Attach option sets to the pizza configuration, if it exists.
        if (pizzaConfig != null) {
            for (OptionSet os : optionSets) {
                pizzaConfig.addOptionSet(os);
            }
        }
        return pizzaConfig;
    }
}
