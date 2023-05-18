package Strategy_Observer;

public class WeatherGovWeatherUpdate{
    private double temperature;
    private double precipitation;
    private double windSpeed;

    public WeatherGovWeatherUpdate(double temperature, double precipitation, double windSpeed){
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
    }

    public double getTemperature(){
        return this.temperature;
    }

    public double getPrecipitation(){
        return this.precipitation;
    }

    public double getWindSpeed(){
        return this.windSpeed;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public void setPrecipitation(double precipitation){
        this.precipitation = precipitation;
    }

    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }

    public String toString(){
        return getTemperature() + " degrees Celsius temperature, " 
        + getPrecipitation() + "% chance of precipitation, " 
        + getWindSpeed() + " km/h wind speed.";
    }
}