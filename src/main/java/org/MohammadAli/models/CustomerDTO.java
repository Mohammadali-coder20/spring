package org.MohammadAli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.MohammadAli.data.entities.BillingAddress;
import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.ShippingAddress;
import org.MohammadAli.validators.Phone;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {

    @NotEmpty
    @Size(min = 4 , max = 10 )
    private String customerName;

    @NotEmpty
    @Email()
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

    @Valid
    private ShippingAddress shippingAddress;

    @Valid
    private BillingAddress billingAddress;

    public static class CREATE extends CustomerDTO{

    }


    public static class REGISTER extends CustomerDTO{

    }

}
