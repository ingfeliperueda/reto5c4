package com.Reto5.repository;

import com.Reto5.model.Product;
import com.Reto5.repository.crud.ProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    
    /**
     * Instancia del ProductCrudRepository
     */
   @Autowired
    private ProductCrudRepository crudInterface;

   /**
    * Metodo que lista los productos
    * @return 
    */
    public List<Product> listAll() {
        return crudInterface.findAll();
    }

    /**
     * Metodo que obtiene un produto por referencia
     * @param reference
     * @return 
     */
    public Optional<Product> getProduct(String reference) {
        return crudInterface.findById(reference);
    }

    /**
     * Metodo que crea un producto
     * @param product
     * @return 
     */
    public Product create(Product product) {
        return crudInterface.save(product);
    }

    /**
     * Metodo que actualiza un producto
     * @param product 
     */
    public void update(Product product) {
        crudInterface.save(product);
    }

    /**
     * Metodo que borra un producto
     * @param product 
     */
    public void delete(Product product) {
        crudInterface.delete(product);
    }
    
    public List<Product> getByPrice(double price){
        return crudInterface.findByPrice(price);
    }

    public List<Product> getByDescriptionContains(String description){
        return crudInterface.findByDescriptionContainingIgnoreCase(description);
    }
}