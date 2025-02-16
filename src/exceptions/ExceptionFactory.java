package exceptions;

/**
 * Factory class for creating custom exceptions.
 */
public class ExceptionFactory {
    public static PizzeriaException createException(String errorType, String message) {
        switch (errorType) {
            case "MissingBasePrice":
                return new MissingBasePriceException(message);
            case "DuplicateOptionSet":
                return new DuplicateOptionSetException(message);
            // Add additional cases as needed.
            default:
                return new PizzeriaException(message);
        }
    }
}
