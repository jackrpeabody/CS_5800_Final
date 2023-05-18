package Strategy_Observer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OpenMeteoWeatherUpdateReformatter implements WeatherUpdateReformatter{
    
    public void reformatWeatherUpdate(WeatherUpdate weatherUpdate){
        // Given data in OpenMeteo format: 
        //          - temperature in degrees fahrenheit, precipitation as a %, dew point in degrees celsius
        // Reformat to the format for the weather forecasting system: 
        //          - temperature in degrees fahrenheit, precipitation as a %, dew point in degrees fahrenheit
        
        double degreesFahrenheit = (weatherUpdate.getDewPoint() * (9/5)) + 32;
        double reformattedDewPoint = new BigDecimal(degreesFahrenheit).setScale(2, RoundingMode.HALF_UP).doubleValue();
        weatherUpdate.setDewPoint(reformattedDewPoint);
        System.out.println("Reformatted OpenMeteo update.");
    }

}