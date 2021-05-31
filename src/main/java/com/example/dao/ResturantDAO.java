package com.example.dao;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.beans.*;
@Repository
public interface ResturantDAO extends JpaRepository<Resturant, Integer>{

	public Resturant findByResName(String resName);
	public ArrayList<Resturant> findByResRating(double resRating);
}
