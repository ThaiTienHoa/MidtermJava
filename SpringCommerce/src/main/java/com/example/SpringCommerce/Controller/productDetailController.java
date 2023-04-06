package com.example.SpringCommerce.Controller;

import com.example.SpringCommerce.Service.ProductService;
import com.example.SpringCommerce.product.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class productDetailController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        product pro = productService.getProductById(id);
        model.addAttribute("product", pro);
        return "productdetail";
    }
}
