package Strategy_Observer;

import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class WeatherForecastingSystem implements WeatherAPIObserver, WeatherGovObserver, OpenMeteoObserver{

    // Store the most recently updated weather data in the format for the weather forecasting system 
    private double temperature; // degrees Fahrenheit
    private double precipitation; // %
    private double humidity; // %
    private double windSpeed; // mi/h
    private double dewPoint; // degrees Fahrenheit

    // Store the most recently received update from weather services
    private Object receivedWeatherUpdate;

    // Store the most recently received update from weather services for reformatting
    private WeatherUpdate weatherUpdate;

    private ArrayList<TemperatureObserver> temperatureObservers = new ArrayList<TemperatureObserver>();
    private ArrayList<PrecipitationObserver> precipitationObservers = new ArrayList<PrecipitationObserver>();
    private ArrayList<HumidityObserver> humidityObservers = new ArrayList<HumidityObserver>();
    private ArrayList<WindSpeedObserver> windSpeedObservers = new ArrayList<WindSpeedObserver>();
    private ArrayList<DewPointObserver> dewPointObservers = new ArrayList<DewPointObserver>();
    
    private WeatherAPIWeatherUpdateReformatter weatherAPIWeatherUpdateReformatter = new WeatherAPIWeatherUpdateReformatter();
    private WeatherGovWeatherUpdateReformatter weatherGovWeatherUpdateReformatter = new WeatherGovWeatherUpdateReformatter();
    private OpenMeteoWeatherUpdateReformatter openMeteoWeatherUpdateReformatter = new OpenMeteoWeatherUpdateReformatter();
    
    private PropertyChangeSupport temperatureSupport = new PropertyChangeSupport(this);
    private PropertyChangeSupport precipitationSupport = new PropertyChangeSupport(this);
    private PropertyChangeSupport humiditySupport = new PropertyChangeSupport(this);
    private PropertyChangeSupport windSpeedSupport = new PropertyChangeSupport(this);
    private PropertyChangeSupport dewPointSupport = new PropertyChangeSupport(this);

    public WeatherForecastingSystem(){
        this.temperature = 0.0;
        this.precipitation = 0.0;
        this.humidity = 0.0;
        this.windSpeed = 0.0;
        this.dewPoint = 0.0;
    }

    public double getTemperature(){
        return this.temperature;
    }

    public double getPrecipitation(){
        return this.precipitation;
    }

    public double getHumidity(){
        return this.humidity;
    }

    public double getWindSpeed(){
        return this.windSpeed;
    }

    public double getDewPoint(){
        return this.dewPoint;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public void setPrecipitation(double precipitation){
        this.precipitation = precipitation;
    }

    public void setHumidity(double humidity){
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }

    public void setDewPoint(double dewPoint){
        this.dewPoint = dewPoint;
    }

    public void addTemperatureObserver(TemperatureObserver observer){
        temperatureSupport.addPropertyChangeListener(observer);
        this.temperatureObservers.add(observer);
        System.out.println(((User) observer).getName() + " observing temperature updates.");
    }

    public void removeTemperatureObserver(TemperatureObserver observer){
        temperatureSupport.removePropertyChangeListener(observer);
        this.temperatureObservers.remove(observer);
        System.out.println(((User) observer).getName() + " no longer observing temperature updates.");
    }

    public void addPrecipitationObserver(PrecipitationObserver observer){
        precipitationSupport.addPropertyChangeListener(observer);
        this.precipitationObservers.add(observer);
        System.out.println(((User) observer).getName() + " observing precipitation updates.");
    }

    public void removePrecipitationObserver(PrecipitationObserver observer){
        precipitationSupport.removePropertyChangeListener(observer);
        this.precipitationObservers.remove(observer);
        System.out.println(((User) observer).getName() + " no longer observing precipitation updates.");
    }

    public void addHumidityObserver(HumidityObserver observer){
        humiditySupport.addPropertyChangeListener(observer);
        this.humidityObservers.add(observer);
        System.out.println(((User) observer).getName() + " observing humidity updates.");
    }

    public void removeHumidityObserver(HumidityObserver observer){
        humiditySupport.removePropertyChangeListener(observer);
        this.humidityObservers.remove(observer);
        System.out.println(((User) observer).getName() + " no longer observing humidity updates.");
    }

    public void addWindSpeedObserver(WindSpeedObserver observer){
        windSpeedSupport.addPropertyChangeListener(observer);
        this.windSpeedObservers.add(observer);
        System.out.println(((User) observer).getName() + " observing wind speed updates.");
    }

    public void removeWindSpeedObserver(WindSpeedObserver observer){
        windSpeedSupport.removePropertyChangeListener(observer);
        this.windSpeedObservers.remove(observer);
        System.out.println(((User) observer).getName() + " no longer observing wind speed updates.");
    }

    public void addDewPointObserver(DewPointObserver observer){
        dewPointSupport.addPropertyChangeListener(observer);
        this.dewPointObservers.add(observer);
        System.out.println(((User) observer).getName() + " observing dew point updates.");
    }

    public void removeDewPointObserver(DewPointObserver observer){
        dewPointSupport.removePropertyChangeListener(observer);
        this.dewPointObservers.remove(observer);
        System.out.println(((User) observer).getName() + " no longer observing dew point updates.");
    }

    public void propertyChange(PropertyChangeEvent event){
        this.receivedWeatherUpdate = event.getNewValue();
        
        if(event.getPropertyName() == "WeatherAPIWeatherUpdate" && this.receivedWeatherUpdate instanceof WeatherAPIWeatherUpdate){
            this.weatherUpdate = this.receiveWeatherAPIWeatherUpdate();
            this.reformatUpdate(this.weatherUpdate, weatherAPIWeatherUpdateReformatter);
            this.sendHumidityUpdate();
            this.setHumidity(this.weatherUpdate.getHumidity());
        }
        else if(event.getPropertyName() == "WeatherGovWeatherUpdate" && this.receivedWeatherUpdate instanceof WeatherGovWeatherUpdate){
            this.weatherUpdate = this.receiveWeatherGovWeatherUpdate();
            this.reformatUpdate(this.weatherUpdate, weatherGovWeatherUpdateReformatter);
            this.sendWindSpeedUpdate();
            this.setWindSpeed(this.weatherUpdate.getWindSpeed());
        }
        else if(event.getPropertyName() == "OpenMeteoWeatherUpdate" && this.receivedWeatherUpdate instanceof OpenMeteoWeatherUpdate){
            this.weatherUpdate = this.receiveOpenMeteoWeatherUpdate();
            this.reformatUpdate(this.weatherUpdate, openMeteoWeatherUpdateReformatter);
            this.sendDewPointUpdate();
            this.setDewPoint(this.weatherUpdate.getDewPoint());
        }

        this.sendTemperatureUpdate();
        this.sendPrecipitationUpdate();
        this.setTemperature(this.weatherUpdate.getTemperature());
        this.setPrecipitation(this.weatherUpdate.getPrecipitation());
    }

    public WeatherUpdate receiveWeatherAPIWeatherUpdate(){
        double receivedTemperature = ((WeatherAPIWeatherUpdate) this.receivedWeatherUpdate).getTemperature();
        double receivedPrecipitation = ((WeatherAPIWeatherUpdate) this.receivedWeatherUpdate).getPrecipitation();
        double receivedHumidity = ((WeatherAPIWeatherUpdate) this.receivedWeatherUpdate).getHumidity();
        return new WeatherUpdate(receivedTemperature, receivedPrecipitation, receivedHumidity, 0.0, 0.0);
    }

    public WeatherUpdate receiveWeatherGovWeatherUpdate(){
        double receivedTemperature = ((WeatherGovWeatherUpdate) this.receivedWeatherUpdate).getTemperature();
        double receivedPrecipitation = ((WeatherGovWeatherUpdate) this.receivedWeatherUpdate).getPrecipitation();
        double receivedWindSpeed = ((WeatherGovWeatherUpdate) this.receivedWeatherUpdate).getWindSpeed();
        return new WeatherUpdate(receivedTemperature, receivedPrecipitation, 0.0, receivedWindSpeed, 0.0);
    }

    public WeatherUpdate receiveOpenMeteoWeatherUpdate(){
        double receivedTemperature = ((OpenMeteoWeatherUpdate) this.receivedWeatherUpdate).getTemperature();
        double receivedPrecipitation = ((OpenMeteoWeatherUpdate) this.receivedWeatherUpdate).getPrecipitation();
        double receivedDewPoint = ((OpenMeteoWeatherUpdate) this.receivedWeatherUpdate).getDewPoint();
        return new WeatherUpdate(receivedTemperature, receivedPrecipitation, 0.0, 0.0, receivedDewPoint);
    }

    public void reformatUpdate(WeatherUpdate weatherUpdate, WeatherUpdateReformatter weatherUpdateReformatter){
        weatherUpdateReformatter.reformatWeatherUpdate(weatherUpdate);
    }

    public void sendTemperatureUpdate(){
        temperatureSupport.firePropertyChange("TemperatureUpdate", this.temperature, this.weatherUpdate.getTemperature());
    }

    public void sendPrecipitationUpdate(){
        precipitationSupport.firePropertyChange("PrecipitationUpdate", this.precipitation, this.weatherUpdate.getPrecipitation());
    }

    public void sendHumidityUpdate(){
        humiditySupport.firePropertyChange("HumidityUpdate", this.humidity, this.weatherUpdate.getHumidity());
    }

    public void sendWindSpeedUpdate(){
        windSpeedSupport.firePropertyChange("WindSpeedUpdate", this.windSpeed, this.weatherUpdate.getWindSpeed());
    }

    public void sendDewPointUpdate(){
        dewPointSupport.firePropertyChange("DewPointUpdate", this.dewPoint, this.weatherUpdate.getDewPoint());
    }

    public String toString(){
        return this.getTemperature() + " degrees Fahrenheit temperature, " 
        + this.getPrecipitation() + "% chance of precipitation, " 
        + this.getHumidity() + "% humidity, "
        + this.getWindSpeed() + " mi/h wind speed, "
        + this.getDewPoint() + " degrees Fahrenheit dew point.";
    }

}
