package com.Reto5.repository;

import com.Reto5.model.User;
import com.Reto5.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    
    /**
    * Instancia del UserCrudRepository 
    */
    @Autowired
    private UserCrudRepository crudInterface;

    /**
    * Metodo que obtiene un usuario por el ID
    * @param id
    * @return
    */
    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    /**
    * Metodo que lista los usuarios
    * @return
    */
    public List<User> listAll() {
        return crudInterface.findAll();
    }

    /**
    *Metodo que valida si existe un email
    * @param email
    * @return
    */
    public boolean emailExists(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
    * Metodo que valida si exise un usuario por Correo y Password
    * @param email
    * @param password
    * @return
    */
    public Optional<User> autenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }

    /**
    * Metodo que realiza la creaciónm de un usuario
    * @param user
    * @return
    */
    public User create(User user) {
        return crudInterface.save(user);
    }
    
    /**
    * Metodo que actualiza un usuario
    * @param user
    * @return
    */
    public User update(User user) {
        return crudInterface.save(user);
    }
    
    /**
    * Metodo que borra un usuario
    * @param user
    * @return
    */
    public void delete(User user) {
        crudInterface.delete(user);
    }
    
    /**
    * Metodo que obtiene el último usuario ingresado
    * @return
    */
    public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }
    
    /**
     * Método que se encarga de retornar el usuario por fecha de cumpleaños
     * @param month
     * @return
     */
    public List<User> getByMonthBirthDay(String month){
        return crudInterface.findByMonthBirthtDay(month);
    }
}