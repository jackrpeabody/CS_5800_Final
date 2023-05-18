package Strategy_Observer;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.beans.PropertyChangeSupport;
import java.math.RoundingMode;

public class OpenMeteo{

    private double temperature;
    private double precipitation;
    private double dewPoint;
    private ArrayList<OpenMeteoObserver> observers = new ArrayList<OpenMeteoObserver>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public OpenMeteo(){
        // Update temperature in degrees fahrenheit, precipitation as a %, dew point in degrees celsius
        this.temperature = 0.0;
        this.precipitation = 0.0;
        this.dewPoint = 0.0;
    }

    public double getUpdatedTemperature(){
        // Randomize temperature update between [50, 80) in degrees fahrenheit for demonstration
        double degreesFahrenheit = 50.0 + (Math.random() * (80.0 - 50.0));
        this.temperature = new BigDecimal(degreesFahrenheit).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.temperature;
    }

    public double getUpdatedPrecipitation(){
        // Randomize precipitation update as a % for demonstration
        this.precipitation = new BigDecimal(Math.random() * 100.0).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.precipitation;
    }

    public double getUpdatedDewPoint(){
        // Randomize dew point update between [5.0, 15.0) in degrees celsius for demonstration
        double degreesCelsius = 5.0 + (Math.random() * (15.0 - 5.0));
        this.dewPoint = new BigDecimal(degreesCelsius).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.dewPoint;
    }

    public ArrayList<OpenMeteoObserver> getObservers(){
        return this.observers;
    }

    public void addObserver(OpenMeteoObserver observer){
        support.addPropertyChangeListener(observer);
        this.observers.add(observer);
        System.out.println("Weather forecasting system observing OpenMeteo.");
    }

    public void removeObserver(OpenMeteoObserver observer){
        support.removePropertyChangeListener(observer);
        this.observers.remove(observer);
        System.out.println("Weather forecasting system no longer observing OpenMeteo.");
    }

    public void sendWeatherUpdate(){
        OpenMeteoWeatherUpdate previousWeatherUpdate = new OpenMeteoWeatherUpdate(this.temperature, 
                                                                                  this.precipitation, 
                                                                                  this.dewPoint);
        OpenMeteoWeatherUpdate weatherUpdate = new OpenMeteoWeatherUpdate(this.getUpdatedTemperature(), 
                                                                          this.getUpdatedPrecipitation(), 
                                                                          this.getUpdatedDewPoint());
        System.out.println("OpenMeteo sending update: " + weatherUpdate + "\n");
        support.firePropertyChange("OpenMeteoWeatherUpdate", previousWeatherUpdate, weatherUpdate);
    }
    
}