package wrapper;

import java.util.ArrayList;
import model.PizzaConfig;

/**
 * API Interface for creating and configuring pizzerias.
 */
public interface CreatePizzeria {
    /**
     * Creates pizzerias with the given name and list of pizza configurations.
     *
     * @param pizzeriaName the name of the pizzeria
     * @param pizzaConfigs list of PizzaConfig objects
     */
    void createPizzerias(String pizzeriaName, ArrayList<PizzaConfig> pizzaConfigs);

    /**
     * Configures a pizzeria using a configuration file.
     *
     * @param filename the name of the configuration file
     */
    void configurePizzeria(String filename);

    /**
     * Prints the details of the specified pizzeria.
     *
     * @param pizzeriaName the name of the pizzeria
     */
    void printPizzeria(String pizzeriaName);
}
