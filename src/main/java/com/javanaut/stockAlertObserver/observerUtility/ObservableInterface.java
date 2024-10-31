package com.javanaut.stockAlertObserver.observerUtility;

public interface ObservableInterface {
    void subscribe(ObservableInterface observableInterface);

    void unsubscribe(ObservableInterface observableInterface);

    void notifyObserver();
}
