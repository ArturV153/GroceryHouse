package com.groceryHouse.groceryhouse.response;


import com.groceryHouse.groceryhouse.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private USER_ROLE role;


}
