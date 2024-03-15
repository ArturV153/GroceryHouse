package com.groceryHouse.groceryhouse.request;


import com.groceryHouse.groceryhouse.model.Category;
import com.groceryHouse.groceryhouse.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long productId;
    private boolean sugarFree;
    private boolean seasional;
    private List<IngredientsItem> ingredients;
}
