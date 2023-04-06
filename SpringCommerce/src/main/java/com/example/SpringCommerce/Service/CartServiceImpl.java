package com.example.SpringCommerce.Service;

import com.example.SpringCommerce.product.CartItem;
import com.example.SpringCommerce.repository.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CartServiceImpl implements CartService {

    private List<CartItem> cartItems;

    public CartServiceImpl() {
        cartItems = new ArrayList<>();
    }

    @Override
    public void addToCart(CartItem item) {
        int index = cartItems.indexOf(item);
        if (index == -1) {
            cartItems.add(item);
        } else {
            CartItem existingItem = cartItems.get(index);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        }
    }

    @Override
    public void removeCartItem(CartItem item) {
        cartItems.remove(item);
    }

    @Override
    public void updateCartItem(CartItem item) {
        int index = cartItems.indexOf(item);
        if (index != -1) {
            cartItems.set(index, item);
        }
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public int getCartSize() {
        return cartItems.size();
    }

    @Override
    public double getCartTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    @Override
    public CartItem getCartItemById(int productId) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == productId) {
                return cartItem;
            }
        }
        return null;
    }
}
