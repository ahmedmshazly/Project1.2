package exceptions;

/**
 * Base custom exception for pizzeria-related errors.
 */
public class PizzeriaException extends Exception {
    public PizzeriaException(String message) {
        super(message);
    }
}
