package webstore.service.impl;/**
 * @author Sergey Zhernovoy
 * create on 16.09.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;
import webstore.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getPrpductByCategory(String category) {
        return this.productRepository.getProductByCategory(category);
    }
}

    