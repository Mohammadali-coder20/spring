package org.MohammadAli.data.entities;

import lombok.*;
import org.MohammadAli.validators.Phone;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Audit implements Serializable {

    @Column
    private static final Long serialVersionUID = 101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @NotEmpty
    @Size(min = 3 , max = 10 , message = "{error.name}")
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmailAddress;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String userName;

    @NotEmpty
    private String password;

    private boolean enabled;


    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

}
