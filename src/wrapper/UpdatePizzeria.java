package wrapper;

/**
 * API Interface for updating existing pizzerias.
 */
public interface UpdatePizzeria {
    /**
     * Updates the name of an OptionSet for the specified pizzeria.
     *
     * @param pizzeriaName  the pizzeria name
     * @param optionSetName the current OptionSet name
     * @param newName       the new name for the OptionSet
     */
    void updateOptionSetName(String pizzeriaName, String optionSetName, String newName);

    /**
     * Updates the base price for the specified pizzeria.
     *
     * @param pizzeriaName the pizzeria name
     * @param newPrice     the new base price
     */
    void updateBasePrice(String pizzeriaName, double newPrice);

    /**
     * Updates the price of a specific option in an OptionSet for the specified pizzeria.
     *
     * @param pizzeriaName  the pizzeria name
     * @param optionSetName the OptionSet name
     * @param optionName    the Option name
     * @param newPrice      the new price for the Option
     */
    void updateOptionPrice(String pizzeriaName, String optionSetName, String optionName, double newPrice);
}
