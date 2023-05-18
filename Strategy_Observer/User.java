package Strategy_Observer;

import java.beans.PropertyChangeEvent;

public class User implements TemperatureObserver, PrecipitationObserver, HumidityObserver,
                             WindSpeedObserver, DewPointObserver{
    
    private final String name;
    private int id;
    private static int nextID = 1;
    private double receivedWeatherDataUpdate;

    public User(String name){
        this.name = name;
        this.id = nextID;
        nextID++;
        System.out.println(name + " created.");
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.id;
    }

    public void propertyChange(PropertyChangeEvent event){;
        if(event.getNewValue() instanceof Double){
            this.receivedWeatherDataUpdate = ((Double) event.getNewValue()).doubleValue();
        }

        if(event.getPropertyName() == "TemperatureUpdate"){
            this.receiveTemperatureUpdate();
        }
        else if(event.getPropertyName() == "PrecipitationUpdate"){
            this.receivePrecipitationUpdate();
        }
        else if(event.getPropertyName() == "HumidityUpdate"){
            this.receiveHumidityUpdate();
        }
        else if(event.getPropertyName() == "WindSpeedUpdate"){
            this.receiveWindSpeedUpdate();
        }
        else if(event.getPropertyName() == "DewPointUpdate"){
            this.receiveDewPointUpdate();
        }
    }

    public double receiveTemperatureUpdate(){
        System.out.println(name + " received temperature update " + this.receivedWeatherDataUpdate + " degrees Fahrenheit.");
        return this.receivedWeatherDataUpdate;
    }

    public double receivePrecipitationUpdate(){
        System.out.println(name + " received precipitation update " + this.receivedWeatherDataUpdate + "%.");
        return this.receivedWeatherDataUpdate;
    }

    public double receiveHumidityUpdate(){
        System.out.println(name + " received humidity update " + this.receivedWeatherDataUpdate + "%.");
        return this.receivedWeatherDataUpdate;
    }

    public double receiveWindSpeedUpdate(){
        System.out.println(name + " received wind speed update " + this.receivedWeatherDataUpdate + " mi/h.");
        return this.receivedWeatherDataUpdate;
    }

    public double receiveDewPointUpdate(){
        System.out.println(name + " received dew point update " + this.receivedWeatherDataUpdate + " degrees Fahrenheit.");
        return this.receivedWeatherDataUpdate;
    }

}
