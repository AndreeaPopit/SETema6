package tema6.se.mcv.interfaces;

/**
 * Created by Andreea on 23.11.2014.
 */
public interface IView {
    /**
     * On message received from controller
     *
     */
    public void onMessage(boolean isError, String message);
}
