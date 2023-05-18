package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface OpenMeteoObserver extends PropertyChangeListener{
    WeatherUpdate receiveOpenMeteoWeatherUpdate();
}