package com.groceryHouse.groceryhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class IngredientsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
   @ManyToOne
    private IngredientsCategory category;
   @JsonIgnore
   @ManyToOne
   private Product product;

   private boolean inStoke=true;


}
