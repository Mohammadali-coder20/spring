package org.MohammadAli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuthoritiesDTO {

    private String username;

    private String authorityType;

    public static class CREATE extends AuthoritiesDTO{

    }

    public static class DELETE extends AuthoritiesDTO{

    }

    public static class RETRIEVE extends AuthoritiesDTO{

    }

}
