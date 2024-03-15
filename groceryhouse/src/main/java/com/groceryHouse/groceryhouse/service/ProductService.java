package com.groceryHouse.groceryhouse.service;

import com.groceryHouse.groceryhouse.dto.ProductDto;
import com.groceryHouse.groceryhouse.model.Product;
import com.groceryHouse.groceryhouse.model.User;
import com.groceryHouse.groceryhouse.request.CreateProductRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductService {

    public Product createProduct(CreateProductRequest req, User user);

    public Product updateProduct(Long productId,CreateProductRequest updatedProduct) throws  Exception;

    public void deleteProduct(Long productId) throws  Exception;

    public List<Product> getAllProduct();

    public List<Product> searchProduct(String keyword);

    public Product findProductById(Long id) throws  Exception;

    public Product getProductByUserId(Long userId) throws Exception;

    public ProductDto addToFavorites(Long productId,User user) throws Exception;

    public Product updateProductStatus(Long id) throws Exception;


}
