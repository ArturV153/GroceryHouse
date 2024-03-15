package com.groceryHouse.groceryhouse.service;

import com.groceryHouse.groceryhouse.dto.ProductDto;


import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.model.User;
import com.groceryHouse.groceryhouse.repository.AddressRepository;
import com.groceryHouse.groceryhouse.repository.ProductRepository;
import com.groceryHouse.groceryhouse.repository.UserRepository;
import com.groceryHouse.groceryhouse.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImp implements ProductService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductRepository productRepository;

    private AddressRepository addressRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;




    @Override
    public Product createProduct(CreateProductRequest req, User user) {


        Product product = new Product ();
        product.getDescription();
        product.setImages(req.getImages());
        product.setName(req.getName());
        product.setCuisineType(req.getCuisineType());






        return productRepository.save(product);
    }

    @Override
     public Product updateProduct(Long productId, CreateProductRequest updatedProduct) throws Exception {
      Product product= findProductById(productId);
      if(product.getCuisineType()!=null){
          product.setCuisineType(updatedProduct.getCuisineType());
      }
         if(product.getDescription()!=null){
             product.setDescription(updatedProduct.getDescription());

         }
         if (product.getName()!=null){
             product.setName(updatedProduct.getName());
         }


        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) throws Exception {

            Product product=findProductById(productId);

            productRepository.delete(product);

    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return productRepository.findByQuery(keyword);
    }

    @Override
    public Product findProductById(Long id) throws Exception {
        Optional<Product> opt = productRepository.findById(id);

        if (opt.isEmpty()){
         throw  new Exception("Продукт не найдено з цим ID"+ id);

        }

        return opt.get();
    }

    @Override
    public Product getProductByUserId(Long userId) throws Exception {

        Product product = productRepository.findByOwnerId(userId);
        if(product==null){
            throw new Exception("Продукт не найдено з виробником ID "+ userId);
        }
        return product;
    }

    @Override
    public ProductDto addToFavorites(Long productId, User user) throws Exception {

        Product product = findProductById(productId);
        ProductDto dto= new ProductDto();
        dto.setDescription(product.getDescription());
        dto.setImages(product.getImages());
        dto.setTitle(product.getName());
        dto.setId(product.getId());



   userRepository.save(user);

        return dto;
    }

    @Override
    public Product updateProductStatus(Long id) throws Exception {

        Product product = findProductById(id);

        return productRepository.save(product);
    }
}
