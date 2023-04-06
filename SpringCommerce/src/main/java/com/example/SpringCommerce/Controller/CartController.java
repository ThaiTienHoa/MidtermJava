package com.example.SpringCommerce.Controller;

import com.example.SpringCommerce.product.CartItem;
import com.example.SpringCommerce.repository.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        double totalAmount = cartService.getCartTotal();
        int totalQuantity = cartService.getCartSize();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("totalQuantity", totalQuantity);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@ModelAttribute("cartItem") CartItem cartItem) {
        cartService.addToCart(cartItem);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update/{productId}")
    public String updateCartItemQuantity(@PathVariable("productId") int productId,
                                         @RequestParam("quantity") int quantity) {
        CartItem cartItem = cartService.getCartItemById(productId);
        if (cartItem == null) {
            return "redirect:/cart";
        }
        cartItem.setQuantity(quantity);
        cartService.updateCartItem(cartItem);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{productId}")
    public String removeCartItem(@PathVariable("productId") int productId) {
        CartItem cartItem = cartService.getCartItemById(productId);
        if (cartItem == null) {
            return "redirect:/cart";
        }
        cartService.removeCartItem(cartItem);
        return "redirect:/cart";
    }
}
