package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.FoodItems;
import com.example.beans.Owner;
import com.example.beans.Resturant;
import com.example.dao.IFoodDAO;
import com.example.dao.IOwnerDAO;
import com.example.dao.ResturantDAO;
import com.example.exception.UserInputException;



@Service
public class ResturantServices{
	@Autowired
    private ResturantDAO dao;
	@Autowired
    private IOwnerDAO dao1;
	@Autowired
    private IFoodDAO dao2;
    public List<Resturant> displayResturants() {
    	List<Resturant> empList = dao.findAll();
    	List<Resturant> list = empList.stream().filter(r-> r.getResRating()>2).collect(Collectors.toList());
        //return dao.findAll();
    	return list;
    }
    public  Resturant addResturant(Resturant resturant)  {
    	dao2.saveAll(resturant.getFooditems());
    	dao1.saveAll(resturant.getOwner3());
        return dao.saveAndFlush(resturant);
 
    }
    public  boolean deleteResturant(int id) throws UserInputException{
        if(dao.findById(id).isPresent()) {
            dao.deleteById(id);
            return true;
        }else
            throw new  UserInputException("ID dosen't exists can't delete");
    }
    public  boolean updateResturant(int id, Resturant resturant) throws UserInputException{
        if(dao.findById(id).isPresent()) {
        	dao2.saveAll(resturant.getFooditems());
        	dao1.saveAll(resturant.getOwner3());
             dao.saveAndFlush(resturant);
             return true;
        }else
            throw new  UserInputException("ID dosen't exists can't update");
    }
    public  Resturant searchResturant(int id3) throws UserInputException{
        if(dao.findById(id3).isPresent()) {
            return dao.findById(id3).get();
        }else
            throw new UserInputException("ID dosen't exists can't search");
    }
    public Resturant searchByResName(String resName) {
        return dao.findByResName(resName);
    }
   
    public ArrayList<Resturant> searchByResRating(double resRating) {
        return dao.findByResRating(resRating);
    }
    public ArrayList<Owner> displayOwner() {
    	return (ArrayList<Owner>) dao1.findAll();
    }
  //addowner
    public  Owner addOwner(Owner owner)  {
        return dao1.saveAndFlush(owner);
    }
    public  ArrayList<FoodItems> displayItems()  {
        return (ArrayList<FoodItems>) dao2.findAll();
    }
}
