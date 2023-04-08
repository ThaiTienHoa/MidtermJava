package com.example.SpringCommerce.Controller;

import com.example.SpringCommerce.Service.CartItemService;
import com.example.SpringCommerce.product.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("")
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
        CartItem newCartItem = cartItemService.createCartItem(cartItem);
        return new ResponseEntity<>(newCartItem, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
//        CartItem cartItem = cartItemService.getCartItemById(id);
//        if (cartItem == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(cartItem, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteCartItemById(@PathVariable Long id) {
//        cartItemService.deleteCartItemById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CartItem> updateCartItemQuantity(@PathVariable Long id, @RequestParam("quantity") int quantity) {
//        CartItem updatedCartItem = cartItemService.updateCartItemQuantity(id, quantity);
//        if (updatedCartItem == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
//    }
}
