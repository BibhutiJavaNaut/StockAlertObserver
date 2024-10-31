package com.javanaut.stockAlertObserver.observerUtility;

public interface ObservableInterface {
    void subscribe(ObserverInterface observerInterface);

    void unsubscribe(ObserverInterface observerInterface);

    void notifyObserver();
}
