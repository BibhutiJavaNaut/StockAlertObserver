package com.javanaut.stockAlertObserver.utility.observerUtility;

public interface ObservableInterface {
    void subscribe(ObserverInterface observerInterface);

    void unsubscribe(ObserverInterface observerInterface);

    void notifyObserver();
}
