package com.example.SpringCommerce.Controller;

import com.example.SpringCommerce.Service.ProductService;
import com.example.SpringCommerce.product.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class productController {
    @Autowired private ProductService service;

    @GetMapping("/product")
    public String showProductList(Model model){
        List<product> productList = service.listAll();
        model.addAttribute("productList", productList);
        return "product";
    }

    @GetMapping("/product/new")
    public String showNewProductForm(Model model) {
        product pro = new product();
        model.addAttribute("product", pro);
        return "new_product";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute("product") product pro) {
        service.addProduct(pro);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int id, Model model) {
        product pro = service.getProductById(id);
        model.addAttribute("product", pro);
        return "edit_product";
    }

    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute("product") product pro, Model model) {
        service.updateProduct(pro);
        List<product> productList = service.listAll();
        model.addAttribute("productList", productList);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id);
        return "redirect:/product";
    }

}
