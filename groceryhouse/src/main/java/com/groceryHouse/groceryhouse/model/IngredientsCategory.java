package com.groceryHouse.groceryhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class IngredientsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;
    @JsonIgnore
   @ManyToOne
    private Product product;
   @OneToMany(mappedBy = "category",cascade =CascadeType.ALL )
    private List<IngredientsItem> Ingredients = new ArrayList<>();

}
