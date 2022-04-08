package org.MohammadAli.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Audit implements Serializable {


    private static final Long serialVersionUID = 101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany( mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER , orphanRemoval = true)
    private List<CartItem> cartItems;

//    @OneToMany( mappedBy = "cart",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER , orphanRemoval = true)
//    private List<CartItem> cartItems;

    private Double grandTotal;

    private boolean isCheckout;

}
