package org.MohammadAli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    private List<CartItem> cartItems;

    private Double grandTotal;

    @Data
    public static class CREATE extends CartDTO{
        private CustomerDTO.CREATE customer;
    }

    public static class DELETE extends CartDTO{

    }

    public static class RETRIEVE extends CartDTO{

    }

}
