package com.Reto5.repository;


import com.Reto5.model.Order;
import com.Reto5.repository.crud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;


@Repository
public class OrderRepository {
    
    /**
    * Instancia del OrderCrudRepository
    */
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    /**
    * Instancia del MongoTemplate
    */
    @Autowired
    private MongoTemplate mongoTemplate;
    
    /**
    * Metodo que lista todas las ordenes
    * @return
    */
    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    /**
    * Metodo que obtiene una orden por id
    * @param id
    * @return
    */
    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    /**
    * Metod que crea una orden
    * @param order
    * @return
    */
    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    /**
    * Metodo que actualiza una orden
    * @param order
    */
    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    /**
    * Metodo que borra una orden
    * @param order
    */
    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    /**
    * Metodo que obtiene la ultima orden
    * @return
    */
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
    /**
    * Metodo que lista las ordenes por zona
    * @param zona
    * @return
    */
    public List<Order> getindByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    
    /**
    *Metodo que trae las ordenes por vendedor
    *@param id
    *@return
    */
    //Reto4
    public List<Order> getordersSalesManByID(Integer id) {
        Query query = new Query() {};
        
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        
        List<Order> orders = mongoTemplate.find(query, Order.class);
        
        return orders;
    }
    
    /**
    *Metodo que obtiene las ordenes por el estado del vendedor
    * @param state
    * @param id
    * @paramid
    * @return 
    */
    public List<Order> getBySalesManIdAndStates(String state, Integer id){
        return orderCrudRepository.findBySalesManIdAndStates(state, id);
    }
    
    /**
     * Metodo que obtiene la ordenes por la fecha de venta que realiza el vendedor
     * @param dateStr
     * @param id
     * @return 
    */
    public List<Order> getordersSalesManByDate(String dateStr, Integer id){
        try {
            return orderCrudRepository.findByordersSalesManByDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}