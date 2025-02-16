package driver;

import wrapper.PizzeriaConfigAPI;

/**
 * FileIOTestDriver tests the file I/O integration in the Pizzeria Configuration API.
 * It reads a pizzeria configuration from a flat file and then prints the configuration.
 */
public class FileIOTestDriver {
    public static void main(String[] args) {
        // Create an instance of the API
        PizzeriaConfigAPI api = new PizzeriaConfigAPI();

        // Provide the path to the configuration file.
        // Ensure that 'config.txt' exists in your project's root or specify the correct path.
        String configFile = "config.txt";

        // Use the API to configure a pizzeria using the flat file.
        api.configurePizzeria(configFile);

        // Print the configuration that was built from the file.
        // Assuming the file defines a PizzaConfig with a name (e.g., "Deluxe Pizza").
        api.printPizzeria("Deluxe Pizza");
    }
}
