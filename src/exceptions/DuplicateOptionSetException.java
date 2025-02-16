package exceptions;

/**
 * Exception thrown when attempting to add an OptionSet that already exists.
 */
public class DuplicateOptionSetException extends PizzeriaException {
    public DuplicateOptionSetException(String message) {
        super(message);
    }
}
