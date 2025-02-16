package test.driver;

import wrapper.PizzeriaConfigAPI;
import model.PizzaConfig;
import model.OptionSet;
import java.util.ArrayList;

/**
 * Test driver for the Pizzeria Configuration API.
 * Demonstrates creation, updating, and printing of pizzerias.
 */
public class PizzeriaAPITestDriver {
    public static void main(String[] args) {
        // Instantiate the concrete API object
        PizzeriaConfigAPI api = new PizzeriaConfigAPI();

        // Create an ArrayList to hold PizzaConfig objects
        ArrayList<PizzaConfig> pizzaConfigs = new ArrayList<>();

        // Create a new PizzaConfig and set its base price
        PizzaConfig config = new PizzaConfig("Deluxe Pizza");
        config.setBasePrice(1500);

        // Create an OptionSet for Size
        OptionSet sizeOptionSet = new OptionSet("Size");
        sizeOptionSet.addOption(sizeOptionSet.new Option("Small", 0));
        sizeOptionSet.addOption(sizeOptionSet.new Option("Medium", 200));
        sizeOptionSet.addOption(sizeOptionSet.new Option("Large", 500));

        // Add the OptionSet to the PizzaConfig (use the created OptionSet, not null)
        config.addOptionSet(sizeOptionSet);

        // Add the PizzaConfig to our list
        pizzaConfigs.add(config);

        // Use the API to create a new pizzeria named "Pizza Palace"
        api.createPizzerias("Pizza Palace", pizzaConfigs);

        // Print the details of "Pizza Palace"
        System.out.println("Initial pizzeria configuration:");
        api.printPizzeria("Pizza Palace");

        // Update the base price and the name of the OptionSet
        api.updateBasePrice("Pizza Palace", 1600);
        api.updateOptionSetName("Pizza Palace", "Size", "Pizza Size");

        // Update the price of the "Medium" option
        api.updateOptionPrice("Pizza Palace", "Pizza Size", "Medium", 250);

        // Print the updated pizzeria configuration
        System.out.println("\nUpdated pizzeria configuration:");
        api.printPizzeria("Pizza Palace");

        // Intentionally trigger an error: try to update a non-existent OptionSet
        System.out.println("\nAttempting to update a non-existent OptionSet:");
        api.updateOptionSetName("Pizza Palace", "NonExistent", "Test");
    }
}
