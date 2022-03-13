package org.MohammadAli.data;

import org.MohammadAli.data.entities.CartItem;
import org.MohammadAli.models.CartItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDAO extends JpaRepository<CartItem , Long> {

    void removeByProduct_ProductID(Long productID);
}
