package com.javanaut.stockAlertObserver.Entity;

import com.javanaut.stockAlertObserver.observerUtility.ObservableInterface;
import com.javanaut.stockAlertObserver.observerUtility.ObserverInterface;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements ObservableInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean isAvailable;
    private Integer numberOfStock;
    @ManyToOne(cascade = CascadeType.ALL)
    private List<ObserverInterface> subscribers = new ArrayList<>();

    @Override
    public void subscribe(ObserverInterface observerInterface) {
        subscribers.add(observerInterface);
    }

    @Override
    public void unsubscribe(ObserverInterface observerInterface) {
        if(subscribers.contains(observerInterface)){
            subscribers.remove(observerInterface);
        }
    }

    @Override
    public void notifyObserver() {
        for(ObserverInterface subscriber : subscribers){
            subscriber.update(this);
        }
    }
}
