package exceptions;

/**
 * Exception thrown when the base price is missing.
 */
public class MissingBasePriceException extends PizzeriaException {
    public MissingBasePriceException(String message) {
        super(message);
    }
}
