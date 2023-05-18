package Strategy_Observer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WeatherGovWeatherUpdateReformatter implements WeatherUpdateReformatter{
    
    public void reformatWeatherUpdate(WeatherUpdate weatherUpdate){
        // Given data in WeatherGov format: 
        //          - temperature in degrees celsius, precipitation as a %, wind speed in km/h
        // Reformat to the format for the weather forecasting system: 
        //          - temperature in degrees fahrenheit, precipitation as a %, wind speed in mi/h
        double degreesFahrenheit = (weatherUpdate.getTemperature() * (9/5)) + 32;
        double reformattedTemperature = new BigDecimal(degreesFahrenheit).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double miH = weatherUpdate.getWindSpeed() / 1.609;
        double reformattedWindSpeed = new BigDecimal(miH).setScale(2, RoundingMode.HALF_UP).doubleValue();
        weatherUpdate.setTemperature(reformattedTemperature);
        weatherUpdate.setWindSpeed(reformattedWindSpeed);
        System.out.println("Reformatted WeatherGov update.");
    }

}