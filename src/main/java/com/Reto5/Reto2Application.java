package com.Reto5;

import com.Reto5.repository.crud.ProductCrudRepository;
import com.Reto5.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public static void main(String[] args) {
	SpringApplication.run(Reto2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      System.out.println("Aqui se ejecutaran la creación de documentos de mongo...");
        
        userCrudRepository.deleteAll();
        productCrudRepository.deleteAll();  
    }
}