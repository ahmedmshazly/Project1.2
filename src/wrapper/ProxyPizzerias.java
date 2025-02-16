package wrapper;

import java.util.LinkedHashMap;
import model.PizzaConfig;

/**
 * Abstract class that implements common functionality for the Pizza Configuration API.
 * Acts as both a Proxy and an Adapter to encapsulate the internal model.
 */
public abstract class ProxyPizzerias {
    // Using a static LinkedHashMap to hold all pizzerias ensures a single shared instance.
    protected static LinkedHashMap<String, PizzaConfig> pizzerias = new LinkedHashMap<>();

    /**
     * Helper method to retrieve a PizzaConfig by pizzeria name.
     *
     * @param pizzeriaName the name of the pizzeria
     * @return the PizzaConfig if found, otherwise null.
     */
    protected PizzaConfig getPizzaConfig(String pizzeriaName) {
        return pizzerias.get(pizzeriaName);
    }
}
