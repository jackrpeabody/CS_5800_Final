package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface WeatherAPIObserver extends PropertyChangeListener{
    WeatherUpdate receiveWeatherAPIWeatherUpdate();
}