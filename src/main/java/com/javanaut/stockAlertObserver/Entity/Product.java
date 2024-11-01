package com.javanaut.stockAlertObserver.Entity;

import com.javanaut.stockAlertObserver.utility.observerUtility.ObservableInterface;
import com.javanaut.stockAlertObserver.utility.observerUtility.ObserverInterface;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements ObservableInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean isAvailable;
    private Integer stock;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> subscribers = new HashSet<>();

    @Override
    public void subscribe(ObserverInterface observerInterface) {
        if(observerInterface instanceof User) {
            subscribers.add((User)observerInterface);
        }
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
