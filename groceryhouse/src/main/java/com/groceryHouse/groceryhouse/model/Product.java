package com.groceryHouse.groceryhouse.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User owner;

    private String name;

    private String description;

    private String cuisineType;
    @OneToOne
    private Address address;

    @Embedded
    private ContactInformation contactInformation;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders= new ArrayList<>();
    @ElementCollection
    @Column(length = 1000)
    private List<String> images;


    private boolean open;
    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private   List<Food> foods = new ArrayList<>();

    








}
