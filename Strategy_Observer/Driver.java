package Strategy_Observer;

public class Driver {
    
    public static void main(String[] args){

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 1 - Weather forecasting system observing all services, user observing all weather data updates:\n");

        // Multiple weather services are used to get weather updates
        WeatherAPI weatherAPI = new WeatherAPI();
        WeatherGov weatherGov = new WeatherGov();
        OpenMeteo openMeteo = new OpenMeteo();

        WeatherForecastingSystem weatherForecastingSystem = new WeatherForecastingSystem();
        weatherAPI.addObserver(weatherForecastingSystem);
        weatherGov.addObserver(weatherForecastingSystem);
        openMeteo.addObserver(weatherForecastingSystem);
        System.out.println();

        // Users can subscribe to specific weather updates
        User user1 = new User("user1");
        System.out.println();

        weatherForecastingSystem.addTemperatureObserver(user1);
        weatherForecastingSystem.addPrecipitationObserver(user1);
        weatherForecastingSystem.addHumidityObserver(user1);
        weatherForecastingSystem.addWindSpeedObserver(user1);
        weatherForecastingSystem.addDewPointObserver(user1);
        System.out.println();

        // Users receive real-time notifications
        weatherAPI.sendWeatherUpdate();
        System.out.println();
        weatherGov.sendWeatherUpdate();
        System.out.println();
        openMeteo.sendWeatherUpdate();
        System.out.println();

        System.out.println("State of the weather forecasting system: " + weatherForecastingSystem);

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 2 - Weather forecasting system observing only WeatherAPI, 2 users observing all weather data updates:\n");

        weatherGov.removeObserver(weatherForecastingSystem);
        openMeteo.removeObserver(weatherForecastingSystem);
        System.out.println();

        User user2 = new User("user2");
        System.out.println();

        weatherForecastingSystem.addTemperatureObserver(user2);
        weatherForecastingSystem.addPrecipitationObserver(user2);
        weatherForecastingSystem.addHumidityObserver(user2);
        weatherForecastingSystem.addWindSpeedObserver(user2);
        weatherForecastingSystem.addDewPointObserver(user2);
        System.out.println();

        // WeatherGov and OpenMeteo updates not received by the weather forecasting system
        weatherAPI.sendWeatherUpdate();
        System.out.println();
        weatherGov.sendWeatherUpdate();
        openMeteo.sendWeatherUpdate();

        System.out.println("State of the weather forecasting system: " + weatherForecastingSystem);

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nSCENARIO 3 - Weather forecasting system observing WeatherGov and OpenMeteo, 3 users observing different weather data updates:\n");

        weatherAPI.removeObserver(weatherForecastingSystem);
        weatherGov.addObserver(weatherForecastingSystem);
        openMeteo.addObserver(weatherForecastingSystem);
        System.out.println();

        User user3 = new User("user3");
        System.out.println();

        weatherForecastingSystem.addWindSpeedObserver(user3);
        weatherForecastingSystem.addDewPointObserver(user3);
        System.out.println();

        weatherForecastingSystem.removeHumidityObserver(user1);
        weatherForecastingSystem.removeWindSpeedObserver(user1);
        weatherForecastingSystem.removeDewPointObserver(user1);
        System.out.println();

        weatherForecastingSystem.removeTemperatureObserver(user2);
        weatherForecastingSystem.removePrecipitationObserver(user2);
        weatherForecastingSystem.removeDewPointObserver(user2);
        System.out.println();

        weatherAPI.sendWeatherUpdate();
        weatherGov.sendWeatherUpdate();
        System.out.println();
        openMeteo.sendWeatherUpdate();
        System.out.println();

        System.out.println("State of the weather forecasting system: " + weatherForecastingSystem);
        System.out.println();
    }

}