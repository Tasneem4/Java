package com.tnsif.onlineshopping.entities;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product findProductById(int id);
}

