package org.MohammadAli.models;


import lombok.*;
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



    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CREATE extends UserDTO{
        private CustomerDTO.CREATE customer;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DELETE extends UserDTO{
        private Long userID;
    }

    public static class RETRIEVE extends UserDTO{

    }


}

