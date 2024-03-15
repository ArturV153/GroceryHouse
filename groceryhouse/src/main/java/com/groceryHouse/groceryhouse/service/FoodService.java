package com.groceryHouse.groceryhouse.service;

import com.groceryHouse.groceryhouse.model.Category;
import com.groceryHouse.groceryhouse.model.Food;
import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Product product);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getProductsFood(Long productId,boolean isSugarFree,
                                      boolean isNoSugarFree,
                                      boolean isSeasonal,
                                      String foodCategory);


  public List<Food> searchFood(String keyword);
  public  Food findFoodById(Long foodId) throws Exception;

  public Food updateAvailabilityStatus(Long foodId) throws Exception;


}
