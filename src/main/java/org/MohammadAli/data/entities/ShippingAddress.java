package org.MohammadAli.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.MohammadAli.models.ShippingAddressDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress extends Audit implements Serializable {


    private static final Long serialVersionUID = 104L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingAddressId;

    @NotEmpty
    private String streetName;

    @NotEmpty
    private String apartmentNumber;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String country;

    @NotEmpty
    private String zipCode;



}
