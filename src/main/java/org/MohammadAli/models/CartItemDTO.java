package org.MohammadAli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    private Cart cart;

    private Product product;

    public static class CREATE extends CartItemDTO{

    }

    public static class DELETE extends CartItemDTO{

    }

    public static class RETRIEVE extends CartItemDTO{

    }
}
