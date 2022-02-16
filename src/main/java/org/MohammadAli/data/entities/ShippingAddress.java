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
public class ShippingAddress extends Audit implements Serializable {

    @Column
    private static final Long serialVersionUID = 104L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingAddressID;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

}
