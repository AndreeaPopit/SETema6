package tema6.se.mcv.controllers;

import tema6.se.mcv.exceptions.UpdateException;
import tema6.se.mcv.interfaces.IController;
import tema6.se.mcv.interfaces.IView;
import tema6.se.mcv.model.UpdateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreea on 23.11.2014.
 */
public class UpdateController implements IController{
    // The Controller needs to interact with both the Model and View.
    private UpdateModel mModel;

    // The list of views that listen for updates
    private List<IView> mViews;

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(ACTION_UPDATE)) {
            // Reset the model to its default state
            if (mModel != null) {
                try {
                    String mTemp = mModel.getTempValue();
                    String mWind = mModel.getWindValue();
                    mModel.setTempValue("1");
                   // mModel.setWindValue(mWind);
                } catch (UpdateException e) {
                    notifyViews(true, e.getMessage());
                }
            }
        }
    }

    /**
     * Adds a view reference in order to interact with it
     *
     */
    public void addView(IView view) {
        if (mViews == null) {
            mViews = new ArrayList<IView>();
        }

        mViews.add(view);
    }

    /**
     * Adds a reference to the model, so it can update it
     */
    public void addModel(UpdateModel model) {
        mModel = model;
    }

    /**
     * Notifies the views when an message must be displayed
     *
     */
    private void notifyViews(boolean isError, String message) {
        if (mViews != null && !mViews.isEmpty()) {
            for (IView view : mViews) {
                view.onMessage(isError, message);
            }
        }
    }

}
