package com.example.SpringCommerce.Controller;

import com.example.SpringCommerce.Service.CartService;
import com.example.SpringCommerce.Service.ProductService;
import com.example.SpringCommerce.product.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;
    @Autowired private CartService cartService;

    @GetMapping("/cart/{productId}")
    public Cart addToCart(@PathVariable(name="productId") Integer productId){
        return cartService.addToCart(productId);
    }
}

