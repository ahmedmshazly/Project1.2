package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PizzaConfig;
import model.OptionSet;

/**
 * Comprehensive test suite for PizzaConfig and OptionSet classes.
 * This class verifies that all CRUD operations and behaviors function correctly.
 */
public class PizzaConfigTest {

    private PizzaConfig pizzaConfig;

    @BeforeEach
    public void setUp() {
        // Create a PizzaConfig with the name "Test Pizza"
        pizzaConfig = new PizzaConfig("Test Pizza");
        pizzaConfig.setBasePrice(1000);
    }

    @Test
    public void testAddAndGetOptionSet() {
        OptionSet sizeSet = new OptionSet("Size");
        pizzaConfig.addOptionSet(sizeSet);

        OptionSet retrieved = pizzaConfig.findOptionSet("Size");
        assertNotNull(retrieved, "Retrieved OptionSet should not be null");
        assertEquals("Size", retrieved.getName(), "OptionSet name should match");
    }

    @Test
    public void testFindOptionSet() {
        OptionSet sizeSet = new OptionSet("Size");
        pizzaConfig.addOptionSet(sizeSet);

        OptionSet found = pizzaConfig.findOptionSet("Size");
        assertNotNull(found, "OptionSet 'Size' should be found");
    }

    @Test
    public void testUpdateOptionSet() {
        OptionSet sizeSet = new OptionSet("Size");
        pizzaConfig.addOptionSet(sizeSet);

        OptionSet newSizeSet = new OptionSet("Updated Size");
        boolean updated = pizzaConfig.updateOptionSet("Size", newSizeSet);
        assertTrue(updated, "OptionSet should be updated successfully");

        OptionSet found = pizzaConfig.findOptionSet("Updated Size");
        assertNotNull(found, "Updated OptionSet should be found");
        assertEquals("Updated Size", found.getName(), "OptionSet name should be updated");
    }

    @Test
    public void testDeleteOptionSet() {
        OptionSet sizeSet = new OptionSet("Size");
        pizzaConfig.addOptionSet(sizeSet);

        boolean deleted = pizzaConfig.deleteOptionSet("Size");
        assertTrue(deleted, "OptionSet should be deleted successfully");

        OptionSet found = pizzaConfig.findOptionSet("Size");
        assertNull(found, "Deleted OptionSet should not be found");
    }

    @Test
    public void testOptionSetCRUDOperations() {
        OptionSet toppingsSet = new OptionSet("Toppings");
        pizzaConfig.addOptionSet(toppingsSet);

        // 1. Create and add an Option
        OptionSet.Option pepperoni = toppingsSet.new Option("Pepperoni", 200);
        toppingsSet.addOption(pepperoni);

        // 2. Retrieve/Find the Option
        OptionSet.Option foundOption = toppingsSet.findOption("Pepperoni");
        assertNotNull(foundOption, "Pepperoni option should be found");

        // 3. Update the Option's price
        boolean updated = toppingsSet.updateOption("Pepperoni", 250);
        assertTrue(updated, "Option price should be updated successfully");
        assertEquals(250, foundOption.getPrice(), "Option price should be updated to 250");

        // 4. Delete the Option
        boolean deleted = toppingsSet.deleteOption("Pepperoni");
        assertTrue(deleted, "Option should be deleted successfully");
        OptionSet.Option deletedOption = toppingsSet.findOption("Pepperoni");
        assertNull(deletedOption, "Deleted option should not be found");
    }

    @Test
    public void testPrintMethodOutput() {
        // Create an OptionSet with one Option and add it to PizzaConfig
        OptionSet sizeSet = new OptionSet("Size");
        pizzaConfig.addOptionSet(sizeSet);
        OptionSet.Option small = sizeSet.new Option("Small", 0);
        sizeSet.addOption(small);

        // Capture the system output to test the print() method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        pizzaConfig.print();
        String output = outContent.toString();

        // Reset System.out
        System.setOut(originalOut);

        // Validate the printed output contains key strings
        assertTrue(output.contains("Test Pizza"), "Output should contain the pizza name");
        assertTrue(output.contains("Size"), "Output should contain the OptionSet name");
        assertTrue(output.contains("Small"), "Output should contain the Option name");
    }
}
