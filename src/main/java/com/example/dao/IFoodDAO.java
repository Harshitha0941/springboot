package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.FoodItems;

@Repository
public interface IFoodDAO extends JpaRepository<FoodItems, Integer> {

}
