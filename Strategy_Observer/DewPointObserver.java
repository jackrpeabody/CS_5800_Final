package Strategy_Observer;

import java.beans.PropertyChangeListener;

public interface DewPointObserver extends PropertyChangeListener{
    double receiveDewPointUpdate();
}
