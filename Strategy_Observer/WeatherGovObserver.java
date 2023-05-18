package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface WeatherGovObserver extends PropertyChangeListener{
    WeatherUpdate receiveWeatherGovWeatherUpdate();
}