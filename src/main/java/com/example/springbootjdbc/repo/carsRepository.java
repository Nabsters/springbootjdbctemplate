package com.example.springbootjdbc.repo;
import com.example.springbootjdbc.model.cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class carsRepository {

    @Autowired
    JdbcTemplate template;

    /*Getting all cars from table*/
    public List<cars> getAllCars(){
        List<cars> carsList = template.query("select registerNo, type,category from cars",(result,rowNum)->new cars(result.getInt("registerNo"),
                result.getString("type"),result.getString("category")));
        return carsList;
    }
    /*Getting a specific car by car registerNo from table*/
    public cars getCars(int registerNo){
        String query = "SELECT * FROM ITEM WHERE registerNo=?";
        cars car = template.queryForObject(query,new Object[]{registerNo},new BeanPropertyRowMapper<>(cars.class));

        return car;
    }
    /*Adding a car into database table*/
    public int addCars(int registerNo,String type,String category){
        String query = "INSERT INTO CARS VALUES(?,?,?)";
        return template.update(query,registerNo,type,category);
    }
    /*delete an item from database*/
    public int deleteCars(int registerNo){
        String query = "DELETE FROM CARS WHERE REGISTERNO =?";
        return template.update(query,registerNo);
    }
}








