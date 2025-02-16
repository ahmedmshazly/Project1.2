package test.driver;

import wrapper.PizzeriaConfigAPI;
import model.PizzaConfig;

/**
 * FileIOTestDriver tests the file I/O integration in the Pizzeria Configuration API.
 * It reads a configuration from a flat file and then prints the resulting pizzeria configuration.
 */
public class FileIOTestDriver {
    public static void main(String[] args) {
        // Create an instance of the API
        PizzeriaConfigAPI api = new PizzeriaConfigAPI();

        // Specify the path to the configuration file.
        // Ensure that 'config.txt' exists in your project's root directory or adjust the path accordingly.
        String configFile = "config.txt";

        // Use the API to configure a pizzeria using the flat file.
        api.configurePizzeria(configFile);

        // Print the configuration that was built from the file.
        // The file should define a PizzaConfig with a name (e.g., "Deluxe Pizza").
        System.out.println("\nPizzeria configuration loaded from file:");
        api.printPizzeria("Deluxe Pizza");
    }
}
