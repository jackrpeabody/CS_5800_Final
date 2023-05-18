package Strategy_Observer;

public class OpenMeteoWeatherUpdate{
    private double temperature;
    private double precipitation;
    private double dewPoint;

    public OpenMeteoWeatherUpdate(double temperature, double precipitation, double dewPoint){
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.dewPoint = dewPoint;
    }

    public double getTemperature(){
        return this.temperature;
    }

    public double getPrecipitation(){
        return this.precipitation;
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

    public void setDewPoint(double dewPoint){
        this.dewPoint = dewPoint;
    }

    public String toString(){
        return getTemperature() + " degrees Fahrenheit temperature, " 
        + getPrecipitation() + "% chance of precipitation, " 
        + getDewPoint() + " degrees Celsius dew point.";
    }
    
}