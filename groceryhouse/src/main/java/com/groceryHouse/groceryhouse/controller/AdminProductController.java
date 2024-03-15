package com.groceryHouse.groceryhouse.controller;


import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.model.User;
import com.groceryHouse.groceryhouse.request.CreateProductRequest;
import com.groceryHouse.groceryhouse.response.MessageResponse;
import com.groceryHouse.groceryhouse.service.ProductService;
import com.groceryHouse.groceryhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
@Autowired
    private ProductService productService;
@Autowired
    private UserService userService;

@PostMapping()
public ResponseEntity<Product> createProduct(
        @RequestBody CreateProductRequest req ,
        @RequestHeader("Авторизація") String jwt)
    throws Exception{
    User user = userService.findUserByJwtToken(jwt);
    Product product = productService.createProduct(req,user);
    return new ResponseEntity<>(product, HttpStatus.CREATED);
}
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @RequestBody CreateProductRequest req ,
            @RequestHeader("Авторизація") String jwt,
            @PathVariable Long id)
            throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        Product product = productService.updateProduct(id,req);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> createProduct(

            @RequestHeader("Авторизація") String jwt,
            @PathVariable Long id)
            throws Exception{
        User user = userService.findUserByJwtToken(jwt);
       productService.deleteProduct(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("Продукт видалився");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Product> updateProduct(

            @RequestHeader("Авторизація") String jwt,
            @PathVariable Long id)
            throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        Product product = productService.updateProductStatus(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<Product> findProductByUserId(

            @RequestHeader("Авторизація") String jwt
            )
            throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        Product product = productService.getProductByUserId(user.getId());
        return new ResponseEntity<>(product,HttpStatus.OK);

    }
    }
























