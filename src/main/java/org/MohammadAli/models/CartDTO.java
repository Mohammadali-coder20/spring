package org.MohammadAli.models;

import lombok.*;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.data.entities.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CartDTO {


    private Double grandTotal;

    @Setter
    @Getter
    public static class CREATE extends CartDTO{
        private CustomerDTO.CREATE customer;
        private Long cartId;
        private List<CartItemDTO.CREATE> cartItems;

    }

    public static class DELETE extends CartDTO{

    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class RETRIEVE extends CartDTO{
        private Long cartId;
        private List<CartItemDTO.RETRIEVE> cartItems;

    }

}
