package Strategy_Observer;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.beans.PropertyChangeSupport;
import java.math.RoundingMode;

public class WeatherGov{

    private double temperature;
    private double precipitation;
    private double windSpeed;
    private ArrayList<WeatherGovObserver> observers = new ArrayList<WeatherGovObserver>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public WeatherGov(){
        // Update temperature in degrees celsius, precipitation as a %, wind speed in km/h
        this.temperature = 0.0;
        this.precipitation = 0.0;
        this.windSpeed = 0.0;
    }

    public double getUpdatedTemperature(){
        // Randomize temperature update between [10, 27) in degrees celsius for demonstration
        double degreesCelsius = 10.0 + (Math.random() * (27.0 - 10.0));
        this.temperature = new BigDecimal(degreesCelsius).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.temperature;
    }

    public double getUpdatedPrecipitation(){
        // Randomize precipitation update as a % for demonstration
        this.precipitation = new BigDecimal(Math.random() * 100.0).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.precipitation;
    }

    public double getUpdatedWindSpeed(){
        // Randomize wind speed update between [2.0, 20.0) im km/h for demonstration
        double kmH = 2.0 + (Math.random() * (20.0 - 2.0));
        this.windSpeed = new BigDecimal(kmH).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.windSpeed;
    }

    public ArrayList<WeatherGovObserver> getObservers(){
        return this.observers;
    }

    public void addObserver(WeatherGovObserver observer){
        support.addPropertyChangeListener(observer);
        this.observers.add(observer);
        System.out.println("Weather forecasting system observing WeatherGov.");
    }

    public void removeObserver(WeatherGovObserver observer){
        support.removePropertyChangeListener(observer);
        this.observers.remove(observer);
        System.out.println("Weather forecasting system no longer observing WeatherGov.");
    }

    public void sendWeatherUpdate(){
        WeatherGovWeatherUpdate previousWeatherUpdate = new WeatherGovWeatherUpdate(this.temperature, 
                                                                                    this.precipitation, 
                                                                                    this.windSpeed);
        WeatherGovWeatherUpdate weatherUpdate = new WeatherGovWeatherUpdate(this.getUpdatedTemperature(), 
                                                                            this.getUpdatedPrecipitation(), 
                                                                            this.getUpdatedWindSpeed());
        System.out.println("WeatherGov sending update: " + weatherUpdate + "\n");
        support.firePropertyChange("WeatherGovWeatherUpdate", previousWeatherUpdate, weatherUpdate);
    }

}