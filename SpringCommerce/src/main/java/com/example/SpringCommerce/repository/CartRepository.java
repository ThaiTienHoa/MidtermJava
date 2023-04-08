package com.example.SpringCommerce.repository;

import com.example.SpringCommerce.product.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
