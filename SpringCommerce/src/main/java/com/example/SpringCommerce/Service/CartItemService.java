package com.example.SpringCommerce.Service;

import com.example.SpringCommerce.product.CartItem;
import com.example.SpringCommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public void deleteCartItemById(Long id) {
        cartItemRepository.deleteById(id);
    }

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);
        if (cartItem == null) {
            return null;
        }
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }
}

