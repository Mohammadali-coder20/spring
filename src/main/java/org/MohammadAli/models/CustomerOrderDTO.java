package org.MohammadAli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.MohammadAli.data.entities.BillingAddress;
import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.Customer;
import org.MohammadAli.data.entities.ShippingAddress;
import org.springframework.stereotype.Component;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerOrderDTO {

    private Cart cart;

    private Customer customer;

    private ShippingAddress shippingAddress;

    private BillingAddress billingAddress;


    public static class CREATE extends CustomerOrderDTO{

    }

    public static class DELETE extends CustomerOrderDTO{

    }

    public static class RETRIEVE extends CustomerOrderDTO{

    }
}
