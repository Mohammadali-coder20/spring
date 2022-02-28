package org.MohammadAli.models;

import lombok.*;
import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.Product;
import org.springframework.stereotype.Component;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CartItemDTO {

    private Long cartItemID;



    private Product product;

    @Setter
    @Getter
    @NoArgsConstructor
    public static class CREATE extends CartItemDTO{
        private CartDTO.CREATE cart;
    }

    public static class DELETE extends CartItemDTO{

    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class RETRIEVE extends CartItemDTO{
        private CartDTO.RETRIEVE cart;

    }
}
