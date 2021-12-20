package com.Reto5.service;

import com.Reto5.model.Product;
import com.Reto5.repository.ProductRepository;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repositorio;

    public List<Product> listAll() {
        return repositorio.listAll();
    }

    public Optional<Product> getProduct(String reference) {
        return repositorio.getProduct(reference);
    }

    public Product create(Product product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return repositorio.create(product);
        }
    }

    public Product update(Product product) {

        if (product.getReference() != null) {
            Optional<Product> accesoryDb = repositorio.getProduct(product.getReference());
            if (!accesoryDb.isEmpty()) {
                if (product.getBrand() != null) {
                    accesoryDb.get().setBrand(product.getBrand());
                }

                if (product.getCategory() != null) {
                    accesoryDb.get().setCategory(product.getCategory());
                }

                if (product.getMaterial() != null) {
                    accesoryDb.get().setMaterial(product.getMaterial());
                }

                if (product.getDescription() != null) {
                    accesoryDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    accesoryDb.get().setPhotography(product.getPhotography());
                }
                accesoryDb.get().setAvailability(product.isAvailability());
                repositorio.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            repositorio.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Product> getByPrice(double price){
        return repositorio.getByPrice(price);
    }

    public List<Product> getByDescriptionContains(String description){
        return repositorio.getByDescriptionContains(description);
    }
}
