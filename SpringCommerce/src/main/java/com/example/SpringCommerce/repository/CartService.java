package com.example.SpringCommerce.repository;

import com.example.SpringCommerce.product.CartItem;

import java.util.List;

public interface CartService {

    void addToCart(CartItem item);

    void removeCartItem(CartItem item);

    void updateCartItem(CartItem item);

    List<CartItem> getCartItems();

    int getCartSize();

    double getCartTotal();

    CartItem getCartItemById(int productId);
}
