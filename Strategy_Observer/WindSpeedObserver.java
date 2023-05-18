package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface WindSpeedObserver extends PropertyChangeListener{
    double receiveWindSpeedUpdate();
}
