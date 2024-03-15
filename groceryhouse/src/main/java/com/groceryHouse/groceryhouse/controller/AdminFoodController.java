package com.groceryHouse.groceryhouse.controller;


import com.groceryHouse.groceryhouse.model.Food;
import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.model.User;
import com.groceryHouse.groceryhouse.response.MessageResponse;
import com.groceryHouse.groceryhouse.service.FoodService;
import com.groceryHouse.groceryhouse.service.ProductService;
import com.groceryHouse.groceryhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
@Autowired
    private FoodService foodService;
@Autowired
    private UserService userService;
@Autowired
    private ProductService productService;
@PostMapping
    public ResponseEntity<Food> createFood(RequestBody CreateFoodRequest req ,
                                           @RequestHeader("Авторизація")String jwt){

       User user = userService.findUserByJwtToken(jwt);
        Product product = productService.findProductById(req.getProductId());
        Food food = foodService.createFood(req, req.getCategory(),product);


        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Авторизація")String jwt){

        User user = userService.findUserByJwtToken(jwt);

        foodService.deleteFood(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("товар успішно видалився ");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvaibilityStatus(@PathVariable Long id,
                                                      @RequestHeader("Авторизація")String jwt){

        User user = userService.findUserByJwtToken(jwt);

       Food food = foodService.updateAvailabilityStatus(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("товар успішно видалився ");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}
