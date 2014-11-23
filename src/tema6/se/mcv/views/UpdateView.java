package tema6.se.mcv.views;

import tema6.se.mcv.interfaces.IController;
import tema6.se.mcv.interfaces.IModelListener;
import tema6.se.mcv.interfaces.IView;
import tema6.se.mcv.model.UpdateModel;
import tema6.se.mcv.utils.CalculateAction;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by Andreea on 23.11.2014.
 */
public class UpdateView extends JFrame implements IModelListener, IView{

    // View Components

    private JTextField mTemperatureTf = new JTextField(7);
    private JTextField mWindSpeedTf = new JTextField(7);
    private JButton mUpdateModelBtn = new JButton("Update Model");

    private IController mCalcController;

    private UpdateModel mModel;

    /**
     * Constructor
     */
    public UpdateView() {
        // Initialize components
        mTemperatureTf.setEditable(false);
        mWindSpeedTf.setEditable(false);

        // Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Temperature"));
        content.add(mTemperatureTf);
        content.add(new JLabel("C   "));
        content.add(new JLabel("Wind Speed"));
        content.add(mWindSpeedTf);
        content.add(new JLabel("km\\h"));
        content.add(mUpdateModelBtn);

        // Finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("Weather");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Sets the view's reference to the model - Only get operations allowed
     *
     * @param model The calc model
     */
    public void addModel(UpdateModel model) {
        mModel = model;

        mTemperatureTf.setText(model.getTempValue());
        mWindSpeedTf.setText(model.getWindValue());
    }

    /**
     * Sets the view's event listener - the controller - so that the changes made by the user in the view, can be reflected in the model
     *
     * @param controller The controller (event listener)
     */
    public void addController(IController controller) {

        mUpdateModelBtn.setActionCommand(IController.ACTION_UPDATE);
        mUpdateModelBtn.addActionListener(controller);

    }

    @Override
    public void onMessage(boolean isError, String message) {
        if (isError) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Weather MVC", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void onUpdate() {
        mTemperatureTf.setText(mModel.getTempValue());
        mWindSpeedTf.setText(mModel.getWindValue());
    }
}
