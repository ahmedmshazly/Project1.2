package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a set of options for a PizzaConfig.
 * Uses an ArrayList to manage Option objects.
 */
public class OptionSet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private ArrayList<Option> options;

    /**
     * Constructor to initialize OptionSet with a name.
     *
     * @param name the name of the option set
     */
    public OptionSet(String name) {
        this.name = name;
        this.options = new ArrayList<>();
    }

    // Getter and setter for name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the list of Options.
     *
     * @return the ArrayList of Option objects.
     */
    public ArrayList<Option> getOptions() {
        return options;
    }

    /**
     * Adds an Option to the OptionSet.
     *
     * @param option the Option object to add
     * @return
     */
    public boolean addOption(Option option) {
        options.add(option);
        return false;
    }

    /**
     * Finds an Option by name.
     *
     * @param name the name of the Option
     * @return the Option if found; otherwise, null.
     */
    public Option findOption(String name) {
        for (Option op : options) {
            if (op.getName().equalsIgnoreCase(name)) {
                return op;
            }
        }
        return null;
    }

    /**
     * Updates an Option's price by its name.
     *
     * @param name     the name of the Option to update
     * @param newPrice the new price for the Option
     * @return true if updated, false if not found.
     */
    public boolean updateOption(String name, double newPrice) {
        Option op = findOption(name);
        if (op != null) {
            op.setPrice(newPrice);
            return true;
        }
        return false;
    }

    /**
     * Deletes an Option by name.
     *
     * @param name the name of the Option to delete
     * @return true if deleted, false otherwise.
     */
    public boolean deleteOption(String name) {
        return options.removeIf(op -> op.getName().equalsIgnoreCase(name));
    }

    /**
     * Prints the details of the OptionSet and its Options.
     */
    public void print() {
        System.out.println("\tOption Set: " + name);
        for (Option op : options) {
            System.out.println("\t\t" + op);
        }
    }

    /**
     * The inner class representing an individual Option.
     */
    public class Option implements Serializable {

        private static final long serialVersionUID = 1L;

        private String name;
        private double price;

        /**
         * Constructor to initialize an Option with a name and price.
         *
         * @param name  the name of the option
         * @param price the additional price for the option
         */
        public Option(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Getters and setters for Option properties

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Option[name=" + name + ", price=" + price + "]";
        }
    }
}
