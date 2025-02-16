package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a Pizza Configuration.
 * Holds a base price and a list of OptionSet objects.
 * Implements Serializable for archiving purposes.
 */
public class PizzaConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private double basePrice;
    private ArrayList<OptionSet> optionSets;

    /**
     * Constructor to initialize PizzaConfig with a name.
     *
     * @param name the name of the pizza configuration
     */
    public PizzaConfig(String name) {
        this.name = name;
        this.basePrice = 0.0; // Default base price, can be updated later
        this.optionSets = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Returns the list of OptionSets.
     *
     * @return the ArrayList of OptionSet objects.
     */
    public ArrayList<OptionSet> getOptionSets() {
        return optionSets;
    }

    /**
     * Adds an OptionSet to the PizzaConfig.
     *
     * @param optionSet the OptionSet object to add
     */
    public void addOptionSet(OptionSet optionSet) {
        optionSets.add(optionSet);
    }

    /**
     * Finds an OptionSet by name.
     *
     * @param name the name of the OptionSet
     * @return the OptionSet if found; otherwise, null.
     */
    public OptionSet findOptionSet(String name) {
        for (OptionSet os : optionSets) {
            if (os.getName().equalsIgnoreCase(name)) {
                return os;
            }
        }
        return null;
    }

    /**
     * Updates an existing OptionSet.
     *
     * @param name         the name of the OptionSet to update
     * @param newOptionSet the new OptionSet data
     * @return true if updated, false if not found.
     */
    public boolean updateOptionSet(String name, OptionSet newOptionSet) {
        for (int i = 0; i < optionSets.size(); i++) {
            if (optionSets.get(i).getName().equalsIgnoreCase(name)) {
                optionSets.set(i, newOptionSet);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes an OptionSet by name.
     *
     * @param name the name of the OptionSet to delete
     * @return true if deleted, false otherwise.
     */
    public boolean deleteOptionSet(String name) {
        return optionSets.removeIf(os -> os.getName().equalsIgnoreCase(name));
    }

    /**
     * Prints the details of the PizzaConfig.
     */
    public void print() {
        System.out.println("Pizza Configuration: " + name);
        System.out.println("Base Price: " + basePrice);
        System.out.println("Option Sets:");
        for (OptionSet os : optionSets) {
            os.print();
        }
    }

    /**
     * Returns the OptionSet at a specified index.
     *
     * @param index the index of the OptionSet
     * @return the OptionSet object if the index is valid; otherwise, null.
     */
    public OptionSet getOptionSet(int index) {
        if (index >= 0 && index < optionSets.size()) {
            return optionSets.get(index);
        }
        return null; // Alternatively, you could throw an exception for an invalid index.
    }
}
