package org.MohammadAli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.MohammadAli.data.entities.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerContactDTO {

    private Long contactID;

    private String contactInfo;

    private Customer customer;


    public static class CREATE extends CustomerContactDTO{

    }

    public static class DELETE extends CustomerContactDTO{

    }

    public static class RETRIEVE extends CustomerContactDTO{

    }
}
