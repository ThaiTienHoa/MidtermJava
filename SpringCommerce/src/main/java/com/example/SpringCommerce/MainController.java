package com.example.SpringCommerce;

//import com.example.SpringCommerce.product.cartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage() {
        return "index";
    }
}

