
package com.Reto5.repository.crud;

import com.Reto5.model.Product;
import com.Reto5.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ProductCrudRepository extends MongoRepository<Product, String>{
    
    public List<Product> findByPrice(double price);
    public List<Product> findByDescriptionContainingIgnoreCase(String description);
}
