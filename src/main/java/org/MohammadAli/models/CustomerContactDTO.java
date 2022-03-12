package org.MohammadAli.models;

import lombok.*;
import org.MohammadAli.data.entities.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerContactDTO {


    private String contactInfo;


    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CREATE extends CustomerContactDTO{
        private CustomerDTO.INFO customer;
    }

    @Data
    public static class DELETE extends CustomerContactDTO{

        private Long contactID;
    }

    @Setter
    @Getter
    public static class RETRIEVE extends CustomerContactDTO{

        private Long contactID;

        private CustomerDTO.INFO customer;

        private Date updateDate;
    }
}
