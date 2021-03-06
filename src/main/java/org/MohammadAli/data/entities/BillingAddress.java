package org.MohammadAli.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
BillingAddress  extends Audit implements Serializable {


    private static final Long serialVersionUID = 103L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressID;


    @NotEmpty
    private String streetName;

    @NotEmpty
    private String apartmentNumber;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    private String state;

    @NotEmpty
    private String country;

}
