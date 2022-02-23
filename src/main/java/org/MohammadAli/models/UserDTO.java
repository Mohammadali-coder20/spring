package org.MohammadAli.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.MohammadAli.data.entities.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {

    private String username;

    private String password;

    private boolean enabled;


    @Data
    public static class CREATE extends UserDTO{
        private CustomerDTO.CREATE customer;
    }

    public static class DELETE extends UserDTO{

    }

    public static class RETRIEVE extends UserDTO{

    }


}

