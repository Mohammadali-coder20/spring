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


@Data
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotEmpty
    @Size(min = 3 , max = 20)
    private String productName;

    @NotEmpty
    @Size(min = 3 , max = 20)
    private String productBrand;

    @NotEmpty
    @Size(min = 3 , max = 20)
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
    @Size(min = 3 , max = 20)
    private String productStatus;

    @NotEmpty
    private String productCategory;



    @Setter
    @Getter
    public static class CREATE extends ProductDTO{

        private Map<String,String> categoryList;

        private MultipartFile productImg;

        public CREATE(){
            super();
            categoryList = new HashMap<>();
            categoryList.put("Laptop","Laptop");
            categoryList.put("Mobile","Mobile");
            categoryList.put("TV","TV");
        }
    }

    @Data
    @AllArgsConstructor
    public static class DELETE{

        private int productID;
    }

    @Data
    public static class RETRIEVE extends ProductDTO{

//        private byte[] img;

        private Long productID;
    }


}
