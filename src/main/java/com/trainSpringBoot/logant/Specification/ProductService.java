package com.trainSpringBoot.logant.Specification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


     public List<Product> searchProducts(String name, String category, Double minPrice, Double maxPrice) {
        Specification<Product> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(ProductSpecification.hasName(name));
        }
        if (category != null) {
            spec = spec.and(ProductSpecification.hasCategory(category));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLessThan(maxPrice));
        }

        return productRepository.findAll(spec);
    }
}
