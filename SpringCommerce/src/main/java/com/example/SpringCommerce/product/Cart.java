package com.example.SpringCommerce.product;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private product pro;



    public Cart(product pro) {
        this.pro = pro;
    }

    public Cart() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
