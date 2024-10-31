package com.javanaut.stockAlertObserver.Entity;

import com.javanaut.stockAlertObserver.utility.observerUtility.ObserverInterface;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User implements ObserverInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Email(message = "Invalid email")
    private String email;

    @Override
    public void update(Object object) {
        if(object instanceof Product) {
            Product product = (Product)object;
            System.out.println("Product " + product.getName()+ " is available now");
        }
    }
}
