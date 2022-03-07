package org.MohammadAli.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem extends Audit implements Serializable {


    private static final Long serialVersionUID = 102L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemID;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;


//    @ManyToOne(fetch = FetchType.EAGER)
//    private Product product;
//
//    @Column (name = "productId", insertable = false, updatable = false)
//    private Long productId;

    private int quantity;

    private double totalPrice;

}
