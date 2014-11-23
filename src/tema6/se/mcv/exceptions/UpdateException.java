package tema6.se.mcv.exceptions;

/**
 * Created by Andreea on 23.11.2014.
 */
public class UpdateException extends Exception {
    /**
     * The constructor for the input exception
     * @param input The input on witch the exception was obtained
     * @param errorMessage  The default exception message
     */
    public UpdateException(String input, String errorMessage) {
        super("Exception on \"" + input + "\" : " + errorMessage);
    }
}
