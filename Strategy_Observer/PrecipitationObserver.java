package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface PrecipitationObserver extends PropertyChangeListener{
    double receivePrecipitationUpdate();
}
