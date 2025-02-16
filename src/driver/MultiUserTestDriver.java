package driver;

import wrapper.PizzeriaConfigAPI;
import scaletests.SimulatedUser;
import model.PizzaConfig;
import model.OptionSet;
import java.util.ArrayList;

/**
 * MultiUserTestDriver demonstrates concurrent modifications to the same pizzeria configuration.
 * It launches multiple threads, each simulating a user that performs updates on the API.
 */
public class MultiUserTestDriver {

    public static void main(String[] args) {
        // Create a shared instance of PizzeriaConfigAPI
        PizzeriaConfigAPI api = new PizzeriaConfigAPI();

        // Create an initial PizzaConfig and OptionSet to simulate an existing configuration
        PizzaConfig config = new PizzaConfig("Deluxe Pizza");
        config.setBasePrice(1500);

        // Create an OptionSet for size
        OptionSet sizeSet = new OptionSet("Pizza Size");
        sizeSet.addOption(sizeSet.new Option("Small", 0));
        sizeSet.addOption(sizeSet.new Option("Medium", 250));
        sizeSet.addOption(sizeSet.new Option("Large", 500));
        config.addOptionSet(sizeSet);

        // Add the configuration to the shared API under the pizzeria name "Pizza Palace"
        ArrayList<PizzaConfig> configList = new ArrayList<>();
        configList.add(config);
        api.createPizzerias("Pizza Palace", configList);

        // Create multiple simulated user threads to update the configuration concurrently
        Thread user1 = new Thread(new SimulatedUser("User1", api));
        Thread user2 = new Thread(new SimulatedUser("User2", api));
        Thread user3 = new Thread(new SimulatedUser("User3", api));

        // Start the threads
        user1.start();
        user2.start();
        user3.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        // Print the final configuration
        System.out.println("\nFinal pizzeria configuration:");
        api.printPizzeria("Pizza Palace");
    }
}
