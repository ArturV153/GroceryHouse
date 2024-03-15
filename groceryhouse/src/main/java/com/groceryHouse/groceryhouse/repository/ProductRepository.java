package com.groceryHouse.groceryhouse.repository;

import com.groceryHouse.groceryhouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT r FROM Product r where lower(r.name) LIKE lower(concat('%',:query,'%') ) " +
            "OR lower(r.cuisineType)" +
            "like lower(concat('%', :query, '%'))")
    List<Product> findByQuery(String query);

    Product findByOwnerId(Long userId);

}
