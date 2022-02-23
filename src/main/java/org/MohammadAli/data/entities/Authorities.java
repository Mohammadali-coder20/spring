package org.MohammadAli.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authoritiesID;

    private String username;

    private String authorityType;

}
