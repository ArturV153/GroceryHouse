package com.groceryHouse.groceryhouse.controller;

import com.groceryHouse.groceryhouse.dto.ProductDto;
import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.model.User;
import com.groceryHouse.groceryhouse.service.ProductService;
import com.groceryHouse.groceryhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
@Autowired
private ProductService productService;
@Autowired
private UserService userService;
@GetMapping("/search")
public ResponseEntity<List<Product>> searchProduct(

        @RequestHeader("Авторизація") String jwt,
        @RequestParam String keyword
        )
    throws Exception{
    User user =userService.findUserByJwtToken(jwt);
    List<Product> product=productService.searchProduct(keyword);
    return new ResponseEntity<>(product, HttpStatus.OK);
}
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(

            @RequestHeader("Авторизація") String jwt

    )
            throws Exception{
        User user =userService.findUserByJwtToken(jwt);
        List<Product> product=productService.getAllProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(

            @RequestHeader("Авторизація") String jwt
            @PathVariable Long id
    )
            throws Exception{
        User user =userService.findUserByJwtToken(jwt);
        List<Product> product=productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/{id}/add-favorite")
    public ResponseEntity<ProductDto> addToFavorites(

            @RequestHeader("Авторизація") String jwt
          @PathVariable Long id
    )
            throws Exception{
        User user =userService.findUserByJwtToken(jwt);
        ProductDto product = productService.addToFavorites(id,user);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

}
