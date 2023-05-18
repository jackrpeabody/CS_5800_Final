package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface TemperatureObserver extends PropertyChangeListener{
    double receiveTemperatureUpdate();
}
