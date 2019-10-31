package com.example.springbootjdbc.controller;
import com.example.springbootjdbc.model.cars;
import com.example.springbootjdbc.repo.carsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class carscontroller {

    @Autowired
    carsRepository carsRepo;

    @RequestMapping("/getAllCars")
    @ResponseBody
    public List<cars> getAllCars(){
        return carsRepo.getAllCars();
    }

    @RequestMapping("/getCars")
    @ResponseBody
    public cars getCars(@RequestParam("registerNo") int registerNo){
        return carsRepo.getCars(registerNo);
    }

    @RequestMapping("/addCars")
    @ResponseBody
    public String addCars(@RequestParam("registerNo") int registerNo,@RequestParam("type") String type,
                          @RequestParam("category") String category){
        if(carsRepo.addCars(registerNo,type,category) >= 1){
            return "Car Added Successfully";
        }else{
            return "Car Not Added !";
        }
    }
    @RequestMapping("/deleteCars")
    @ResponseBody
    public String deleteCars(@RequestParam("registerNo") int registerNo){
        if(carsRepo.deleteCars(registerNo) >= 1){
            return "Car Deleted Successfully";
        }else{
            return "Car Not Deleted !";
        }
    }
}


