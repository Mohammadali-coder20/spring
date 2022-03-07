package org.MohammadAli.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.data.entities.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.security.PrivateKey;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Accessors(chain = true)
//@JsonIgnoreProperties(ignoreUnknown = true)
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
//    @JsonIgnore(ign)
    public static class RETRIEVE extends CartDTO{
        private Long cartId;
//        @JsonIgnore
        private List<CartItemDTO.RETRIEVE> cartItems;

    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class INFO extends CartDTO{
        private Long cartId;
        private List<CartItemDTO.RETRIEVE> cartItems;

    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TEST extends CartDTO{

        private List<CartItemDTO.RETRIEVE> cartItems;

        private Long cartId;

    }

}
