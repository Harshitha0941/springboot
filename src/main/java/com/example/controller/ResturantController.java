package com.example.controller;


import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.FoodItems;
import com.example.beans.Owner;
import com.example.beans.Resturant;
import com.example.exception.UserInputException;
import com.example.service.ResturantServices;

@RestController
@RequestMapping("api/v2")
public class ResturantController {
	@Autowired
    private ResturantServices rs;
    @GetMapping("/display")
    public ArrayList<Resturant> sayHello() {
        ArrayList<Resturant> ls=new ArrayList<Resturant>();
        ls= (ArrayList<Resturant>) rs.displayResturants();
        return ls;
    }
    
    @PostMapping("/add")
    public ResponseEntity<Resturant> saveUser(@RequestBody Resturant resturant) throws UserInputException {
      // Employee employee1 = es.addEmployee(employee);
         return new ResponseEntity<Resturant>(rs.addResturant(resturant),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{resId}")
    public ResponseEntity<Boolean> delRes(@PathVariable int resId) throws UserInputException {
       
        return new ResponseEntity<Boolean>(rs.deleteResturant(resId),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateRes(@PathVariable int id,@RequestBody Resturant resturant) throws UserInputException {
       
       return new ResponseEntity<Boolean>(rs.updateResturant(id,resturant),HttpStatus.OK);
    }

    @GetMapping("/getRes/{id}")
    public ResponseEntity<Resturant> getResOnId(@PathVariable int id) throws UserInputException {
      // List<Employee> empList=es.searchEmployee(id);
       return new ResponseEntity<Resturant>(rs.searchResturant(id),HttpStatus.OK);
    }    
    @GetMapping("/searchByName/{resName}")
    public ResponseEntity<Resturant> searchByResName(@PathVariable String resName)throws UserInputException {
    // List<Employee> empList=es.searchEmployee(id);
    return new ResponseEntity<Resturant>(rs.searchByResName(resName),HttpStatus.OK);
    }
   
    @GetMapping("/searchByRating/{resRating}")
    public ResponseEntity<ArrayList<Resturant>> searchByResRating(@PathVariable double resRating)throws UserInputException {
    // List<Employee> empList=es.searchEmployee(id);
    return new ResponseEntity<ArrayList<Resturant>>(rs.searchByResRating(resRating),HttpStatus.OK);
    }
    @GetMapping("/displayOwner")
    public ArrayList<Owner> displayOwner() {
        ArrayList<Owner> ls=new ArrayList<Owner>();
        ls= (ArrayList<Owner>) rs.displayOwner();
        return ls;
    }
    @GetMapping("/displayFood")
    public ArrayList<FoodItems> displayFood() {
        ArrayList<FoodItems> ls=new ArrayList<FoodItems>();
        ls= rs.displayItems();
        return ls;
    }
   
}