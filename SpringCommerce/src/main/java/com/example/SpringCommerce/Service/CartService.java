package com.example.SpringCommerce.Service;

import com.example.SpringCommerce.product.Cart;
import com.example.SpringCommerce.product.CartItem;
import com.example.SpringCommerce.product.product;
import com.example.SpringCommerce.repository.CartItemRepository;
import com.example.SpringCommerce.repository.CartRepository;
import com.example.SpringCommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private productRepository proRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart addToCart(Integer productId){
        product pro = proRepository.findById(productId).get();
        if(pro != null){
            Cart cart = new Cart(pro);
            return cartRepository.save(cart);
        }
        return null;
    }
}

