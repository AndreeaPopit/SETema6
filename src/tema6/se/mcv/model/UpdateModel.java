package tema6.se.mcv.model;

import tema6.se.mcv.exceptions.UpdateException;
import tema6.se.mcv.interfaces.IModelListener;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Andreea on 23.11.2014.
 */
public class UpdateModel {

    private float mTemperature;
    private float mWindSpeed;
    private List<IModelListener> mListeners;

    private float minTemp = -40.0f;
    private float maxTemp = 40.0f;
    Random randTemp = new Random();

    private float minWind = 0.0f;
    private float maxWind = 52.0f;
    Random randWind = new Random();

    public void UpdateTemp(){
        mTemperature = randTemp.nextFloat()*(maxTemp-minTemp)+minTemp;
    }
    public void UpdateWind(){
        mWindSpeed = randWind.nextFloat()*(maxWind-minWind)+minWind;
    }

    public void setTempValue(String tempValue) throws UpdateException{
        try{
            mTemperature = Float.parseFloat(tempValue);
            notifyListeners();
        }catch (Exception e){
            throw new UpdateException(tempValue,e.getMessage());
        }
    }

    public void setWindValue(String windValue) throws UpdateException{
        try{
            mWindSpeed = Float.parseFloat(windValue);
            notifyListeners();
        }catch (Exception e){
            throw new UpdateException(windValue,e.getMessage());
        }
    }
    /**
     * Return current Temperature and Wind Speed.
     */

    public String getTempValue(){
        UpdateTemp();
        DecimalFormat df = new DecimalFormat("#.#");
        return String.valueOf(df.format(mTemperature));
    }
    public String getWindValue(){
        UpdateWind();
        DecimalFormat df = new DecimalFormat("#.#");
        return String.valueOf(df.format(mWindSpeed));
    }
    /**
     * Adds the view listener to the list
     *
     * @param listener The model event listener
     */
    public void addModelListener(IModelListener listener) {
        if (mListeners == null) {
            mListeners = new ArrayList<IModelListener>();
        }

        mListeners.add(listener);
    }

    /**
     * Notifies the views listeners of the changed state (value)
     */
    private void notifyListeners() {
        if (mListeners != null && !mListeners.isEmpty()) {
            for (IModelListener listener : mListeners)
                listener.onUpdate();
        }
    }


}
