package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface HumidityObserver extends PropertyChangeListener{
    double receiveHumidityUpdate();
}
