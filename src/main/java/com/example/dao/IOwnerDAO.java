package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.Owner;
import com.example.beans.Resturant;

@Repository
public interface IOwnerDAO extends JpaRepository<Owner, Integer>{

}
