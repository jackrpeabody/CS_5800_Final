package Strategy_Observer;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.beans.PropertyChangeSupport;
import java.math.RoundingMode;

public class WeatherAPI{

    private double temperature;
    private double precipitation;
    private double humidity;
    private ArrayList<WeatherAPIObserver> observers = new ArrayList<WeatherAPIObserver>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public WeatherAPI(){
        // Update temperature in degrees fahrenheit, precipitation as a decimal, humidity as a decimal
        this.temperature = 0.0;
        this.precipitation = 0.0;
        this.humidity = 0.0;
    }

    public double getUpdatedTemperature(){
        // Randomize temperature update between [50, 80) in degrees fahrenheit for demonstration
        double degreesFahrenheit = 50.0 + (Math.random() * (80.0 - 50.0));
        this.temperature = new BigDecimal(degreesFahrenheit).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.temperature;
    }

    public double getUpdatedPrecipitation(){
        // Randomize precipitation update as a decimal between [0.0, 1.0) for demonstration
        this.precipitation = new BigDecimal(Math.random()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.precipitation;
    }

    public double getUpdatedHumidity(){
        // Randomize humidity update as a decimal between [0.0, 1.0) for demonstration
        this.humidity = new BigDecimal(Math.random()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return this.humidity;
    }

    public ArrayList<WeatherAPIObserver> getObservers(){
        return this.observers;
    }

    public void addObserver(WeatherAPIObserver observer){
        support.addPropertyChangeListener(observer);
        this.observers.add(observer);
        System.out.println("Weather forecasting system observing WeatherAPI.");
    }

    public void removeObserver(WeatherAPIObserver observer){
        support.removePropertyChangeListener(observer);
        this.observers.remove(observer);
        System.out.println("Weather forecasting system no longer observing WeatherAPI.");
    }

    public void sendWeatherUpdate(){
        WeatherAPIWeatherUpdate previousWeatherUpdate = new WeatherAPIWeatherUpdate(this.temperature, 
                                                                                    this.precipitation, 
                                                                                    this.humidity);
        WeatherAPIWeatherUpdate weatherUpdate = new WeatherAPIWeatherUpdate(this.getUpdatedTemperature(), 
                                                                            this.getUpdatedPrecipitation(), 
                                                                            this.getUpdatedHumidity());
        System.out.println("WeatherAPI sending update: " + weatherUpdate + "\n");
        support.firePropertyChange("WeatherAPIWeatherUpdate", previousWeatherUpdate, weatherUpdate);
    }

}