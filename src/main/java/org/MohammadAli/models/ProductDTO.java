package org.MohammadAli.models;


import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Component
public class ProductDTO {

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String productName;

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String productBrand;

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String productModel;

    @NotEmpty
    private String productDescription;

    @NotNull
    @Range(min = 0)
    private Double productPrice;

    @NotNull
    @Range(min = 0)
    private Double unitInStock;

    @NotNull
    @Range(min = 0)
    private Double discount;

    @NotEmpty
    @Size(min = 3 , max = 10)
    private String productStatus;

    @NotEmpty
    private String productCategory;


    private MultipartFile productImg;


    private Map<String,String> categoryList;

    public ProductDTO(){
        categoryList = new HashMap<>();
        categoryList.put("Laptop","Laptop");
        categoryList.put("Mobile","Mobile");
        categoryList.put("TV","TV");
    }


    public static class CREATE extends ProductDTO{

    }

    @Data
    @AllArgsConstructor
    public static class DELETE{
        private int id;
    }
}
