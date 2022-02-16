package org.MohammadAli.data.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Data
@AllArgsConstructor
public class Product extends Audit implements Serializable {

    @Column
    private static final Long serialVersionUID = 100L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String productBrand;

    @NotEmpty
    private String productModel;

    @NotNull
    @Range(min = 0)
    private Double productPrice;

    @NotNull
    @Range(min = 0)
    private Double unitInStock;

    @Transient
    private MultipartFile productImg;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @Transient
    private Map<String,String> categoryList;

    public Product(){
        categoryList = new HashMap<>();
        categoryList.put("Laptop","Laptop");
        categoryList.put("Mobile","Mobile");
        categoryList.put("TV","TV");
    }
}
