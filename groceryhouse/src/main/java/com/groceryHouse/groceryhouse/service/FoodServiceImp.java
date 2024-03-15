package com.groceryHouse.groceryhouse.service;

import com.groceryHouse.groceryhouse.model.Category;
import com.groceryHouse.groceryhouse.model.Food;
import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.repository.FoodRepository;
import com.groceryHouse.groceryhouse.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImp implements FoodService {
    @Autowired
    private FoodRepository foodRepository;


    @Override
    public Food createFood(CreateFoodRequest req, Category category, Product product) {
        Food food = new Food();

        food.setFoodCategory(category);

        food.setProduct(product);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredients(req.getIngredients());
        food.setSeasonal(req.isSeasional());
        food.setSugarFree(req.isSugarFree());


        Food savedFood = foodRepository.save(food);
       product.getFoods().add(savedFood);
        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
         Food food = findFoodById(foodId);
         food.setProduct(null);
         foodRepository.save(food);
    }

    @Override
    public List<Food> getProductsFood(Long productId,
                                      boolean isSugarFree,
                                      boolean isNoSugarFree,
                                      boolean isSeasonal, String foodCategory) {


        List<Food> foods = foodRepository.findByProductId(productId);

        if (isSugarFree){
            foods= filterBySugarFree(foods,isSugarFree);
        }
        if (isNoSugarFree){
            foods= filterByNoSugarFree(foods,isNoSugarFree);
        }
        if (isSeasonal){
            foods= filterBySeasonal(foods,isSeasonal);
        }
        if (foodCategory!=null && !foodCategory.equals("")){
            foods= filterByCategory(foods,foodCategory);
        }
        
        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {

        return foods.stream().filter(food -> {
            if (food.getFoodCategory()!=null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {
        return foods.stream().filter(food -> food.isSeasonal()==isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterByNoSugarFree(List<Food> foods, boolean isNoSugarFree) {
        return foods.stream().filter(food -> food.isSugarFree()==false).collect(Collectors.toList());
    }

    private List<Food> filterBySugarFree(List<Food> foods, boolean isSugarFree) {
        return foods.stream().filter(food -> food.isSugarFree()==isSugarFree).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyword) {

        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        Optional<Food> optionalFood=foodRepository.findById(foodId);
        if(optionalFood.isEmpty()){
            throw new Exception("їжі немає...");
        }
        return optionalFood.get() ;
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {

        Food food = findFoodById(foodId);
        food.setAvailable(!food.isAvailable());

        return foodRepository.save(food);

    }
}
