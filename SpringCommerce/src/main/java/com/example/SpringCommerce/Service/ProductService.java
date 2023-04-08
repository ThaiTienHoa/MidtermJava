package com.example.SpringCommerce.Service;

import com.example.SpringCommerce.product.product;
import com.example.SpringCommerce.repository.productRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private productRepository repo;

    @PersistenceContext
    private EntityManager entityManager;
    public List<product> listAll(){
        return (List<product>) repo.findAll();
    }

    public product getProductById(int id){
        return repo.findById(id).orElse(null);
    }

    public product addProduct(product pro){
        return repo.save(pro);
    }

    public boolean isExistByUserId(int id)
    {
        Optional<product>pro = Optional.ofNullable(repo.findById(id).orElse(new product()));

        return pro.isPresent();
    }

    @Transactional
    public product updateProduct(product pro) {
        System.out.println("Updating product with ID: " + pro.getId());

        Optional<product>optionalProduct = Optional.ofNullable(repo.findById(pro.getId()).orElse(new product()));
        if (optionalProduct.isPresent()) {
            product existingProduct = optionalProduct.get();
            existingProduct.setCategory(pro.getCategory());
            existingProduct.setPrice(pro.getPrice());
            existingProduct.setColor(pro.getColor());
            existingProduct.setBrand(pro.getBrand());

            return repo.save(existingProduct);
        } else {
            System.err.println("Product not found with ID: " + pro.getId());
            throw new RuntimeException("Product not found");
        }
    }


    public void deleteProduct(int id){
        repo.deleteById(id);
    }

}
