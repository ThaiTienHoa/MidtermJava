package com.example.SpringCommerce;

import com.example.SpringCommerce.product.product;
import com.example.SpringCommerce.repository.productRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class productRepositoryTest {
    @Autowired private productRepository repo;

    @Test
    public void testAddnew(){
        product pro = new product();
        pro.setCategory("NokiaA1");
        pro.setPrice(111111);
        pro.setBrand("Nokia");
        pro.setColor("Pink");

        product savePro = repo.save(pro);
        Assertions.assertThat(savePro).isNotNull();
        Assertions.assertThat(savePro.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<product> products = repo.findAll();
        Assertions.assertThat(products).hasSizeGreaterThan(0);

        for(product prod : products){
            System.out.println(prod);
        }
    }
    @Test
    public void testUpdate(){
        Integer productId = 1;
        Optional<product> optionalProduct = repo.findById(productId);
        product pro = optionalProduct.get();
        pro.setBrand("Vmarts");
        repo.save(pro);

        product updateProduct = repo.findById(productId).get();
        Assertions.assertThat(updateProduct.getBrand()).isEqualTo("Vmarts");
    }

    @Test
    public void testGet(){
        Integer productId = 2;
        Optional<product> optionalProduct = repo.findById(productId);
        Assertions.assertThat(optionalProduct).isPresent();
        System.out.println(optionalProduct.get());
    }

    @Test
    public void testDelete(){
        Integer productId = 3;
        repo.deleteById(productId);

        Optional<product> optionalProduct = repo.findById(productId);
        Assertions.assertThat(optionalProduct).isNotPresent();
    }
}
