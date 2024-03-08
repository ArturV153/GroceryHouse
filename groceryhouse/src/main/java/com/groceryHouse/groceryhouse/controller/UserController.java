package com.groceryHouse.groceryhouse.controller;


import com.groceryHouse.groceryhouse.model.User;
import com.groceryHouse.groceryhouse.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

@GetMapping("/profile")
    public ResponseEntity<User> findByJwtToken(@RequestHeader("авторизація") String jwt) throws Exception {

   User user=userService.findUserByJwtToken(jwt);
   return new ResponseEntity<>(user, HttpStatus.OK);

    }

}
