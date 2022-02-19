package org.MohammadAli.models;


import lombok.*;
import org.springframework.stereotype.Component;


import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Component
public class ProductDTO {
    private int id;
    @Size(min = 3 , message ="{error.name}")
    private String name;
    @Min(value = 1000 , message = "{error.price}")
    private int price;
    private String Type;
    private String color;
    private List<Integer> sizes;
    private Map<String,String> validTypes;


    public ProductDTO(){
        validTypes = new HashMap<>();
        validTypes.put("1","Home");
        validTypes.put("2","Work");
        validTypes.put("3","School");
        validTypes.put("4","Electronics");
    }


    public static class CREATE extends ProductDTO{

    }

    @Data
    @AllArgsConstructor
    public static class DELETE{
        private int id;
    }
}
