package Strategy_Observer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WeatherAPIWeatherUpdateReformatter implements WeatherUpdateReformatter{
    
    public void reformatWeatherUpdate(WeatherUpdate weatherUpdate){
        // Given data in WeatherAPI format: 
        //          - temperature in degrees fahrenheit, precipitation as a decimal, humidity as a decimal
        // Reformat to the format for the weather forecasting system: 
        //          - temperature in degrees fahrenheit, precipitation as a %, humidity as a %

        double reformattedPrecipitation = new BigDecimal(weatherUpdate.getPrecipitation() * 100.0).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double reformattedHumidity = new BigDecimal(weatherUpdate.getHumidity() * 100.0).setScale(2, RoundingMode.HALF_UP).doubleValue();
        weatherUpdate.setPrecipitation(reformattedPrecipitation);
        weatherUpdate.setHumidity(reformattedHumidity);
        System.out.println("Reformatted WeatherAPI update.");
    }

}
