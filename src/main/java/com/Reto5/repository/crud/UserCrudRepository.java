package com.Reto5.repository.crud;

import com.Reto5.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
    
    public Optional<User> findTopByOrderByIdDesc();
    
    List<User> findByMonthBirthtDay(String month);
}
