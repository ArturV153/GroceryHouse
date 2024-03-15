package com.groceryHouse.groceryhouse.repository;

import com.groceryHouse.groceryhouse.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

    List<Food> findByProductId(Long productId);

    @Query("SELECT  f from f WHERE  f.name LIKE %:keyword% OR f.foodCategory.name LIKE %:keyword%")
    List<Food>searchFood(@Param("keyword") String keyword );

}
