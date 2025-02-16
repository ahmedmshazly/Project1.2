package scaletests;

import wrapper.PizzeriaConfigAPI;

/**
 * SimulatedUser represents a user interacting with the Pizzeria Configuration API.
 * Each SimulatedUser runs in its own thread and performs various API operations.
 */
public class SimulatedUser implements Runnable {

    private final String userName;
    private final PizzeriaConfigAPI api;

    /**
     * Constructs a SimulatedUser with a given user name and shared API instance.
     *
     * @param userName the name of the simulated user
     * @param api the shared PizzeriaConfigAPI instance
     */
    public SimulatedUser(String userName, PizzeriaConfigAPI api) {
        this.userName = userName;
        this.api = api;
    }

    /**
     * The run method simulates API operations such as updating the base price
     * and modifying option prices concurrently.
     */
    @Override
    public void run() {
        try {
            // Simulate updating the base price
            System.out.println(userName + " is updating the base price...");
            api.updateBasePrice("Pizza Palace", 1700);
            System.out.println(userName + " updated the base price.");

            // Simulate updating the price of an option in an OptionSet
            System.out.println(userName + " is updating the price of 'Medium' option...");
            api.updateOptionPrice("Pizza Palace", "Pizza Size", "Medium", 300);
            System.out.println(userName + " updated the price of 'Medium' option.");

            // Additional operations can be simulated as needed
        } catch (Exception e) {
            System.err.println(userName + " encountered an error: " + e.getMessage());
        }
    }
}
