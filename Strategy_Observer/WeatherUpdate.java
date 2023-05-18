package Strategy_Observer;

public class WeatherUpdate{
    
    private double temperature;
    private double precipitation;
    private double humidity;
    private double windSpeed;
    private double dewPoint;

    public WeatherUpdate(double temperature, double precipitation, double humidity, 
                                                 double windSpeed, double dewPoint){
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.dewPoint = dewPoint;
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

    public String toString(){
        return this.getTemperature() + " degrees Fahrenheit temperature, " 
        + this.getPrecipitation() + "% chance of precipitation, " 
        + this.getHumidity() + "% humidity, "
        + this.getWindSpeed() + " mi/h wind speed, "
        + this.getDewPoint() + " degrees Fahrenheit dew point.";
    }
}
