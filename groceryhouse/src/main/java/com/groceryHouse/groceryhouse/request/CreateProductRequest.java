package com.groceryHouse.groceryhouse.request;


import com.groceryHouse.groceryhouse.model.Address;
import com.groceryHouse.groceryhouse.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateProductRequest {

    private  Long id;
    private String name;
    private String description;
    private String cuisineType;
    private ContactInformation contactInformation;
    private List<String> images;



}
