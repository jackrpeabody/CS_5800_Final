package Strategy_Observer;

public class WeatherAPIWeatherUpdate{
    private double temperature;
    private double precipitation;
    private double humidity;

    public WeatherAPIWeatherUpdate(double temperature, double precipitation, double humidity){
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.humidity = humidity;
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

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public void setPrecipitation(double precipitation){
        this.precipitation = precipitation;
    }

    public void setHumidity(double humidity){
        this.humidity = humidity;
    }

    public String toString(){
        return getTemperature() + " degrees Fahrenheit temperature, " 
        + getPrecipitation() + " precipitation, " 
        + getHumidity() + " humidity.";
    }

}