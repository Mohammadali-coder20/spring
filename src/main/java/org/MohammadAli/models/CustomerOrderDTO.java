package org.MohammadAli.models;

import lombok.*;
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

    private ShippingAddress shippingAddress;

    private BillingAddress billingAddress;

    @Setter
    @Getter
    @NoArgsConstructor
    public static class CREATE extends CustomerOrderDTO{

        private CartDTO.CREATE cart;

        private CustomerDTO.CREATE customer;

    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class DELETE extends CustomerOrderDTO{

        private CartDTO.DELETE cart;

        private CustomerDTO.DELETE customer;

    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class RETRIEVE extends CustomerOrderDTO{

        private Long customerOrderID;

        private CartDTO.RETRIEVE cart;

        private CustomerDTO.RETRIEVE customer;

    }
}
