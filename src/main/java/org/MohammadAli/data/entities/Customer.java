package org.MohammadAli.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.MohammadAli.validators.Phone;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Audit implements Serializable {

    @Column
    private static final Long serialVersionUID = 101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmail;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String userName;

    @NotEmpty
    private String password;

    private boolean enabled;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @Valid
    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @Valid
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;












}
