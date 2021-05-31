package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="fooditems")
public class FoodItems {
	
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="food_id")
	    private int foodId;
	    @Column(name="food_name")
	    private String foodName;
	    @Column(name="food_price")
	    private String foodPrice;
	}

