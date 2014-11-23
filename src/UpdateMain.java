import tema6.se.mcv.controllers.UpdateController;
import tema6.se.mcv.model.UpdateModel;
import tema6.se.mcv.views.UpdateView;

/**
 * Created by Andreea on 23.11.2014.
 */
public class UpdateMain {
    public static void main(String[] args) {
        // Instantiate the MVC elements
        UpdateModel model = new UpdateModel();
        UpdateView view = new UpdateView();
        UpdateController controller = new UpdateController();

        // Attach the view to the model
        model.addModelListener(view);

        // Tell the view about the model and the controller
        view.addModel(model);
        view.addController(controller);

        // Tell the controller about the model and the view
        controller.addModel(model);
        controller.addView(view);

        // Display the view
        view.setVisible(true);
    }
}
