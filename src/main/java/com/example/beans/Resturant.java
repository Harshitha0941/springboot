package com.example.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name="resturant3")
public class Resturant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="res_id")
    private int resId;
    @Column(name="res_name")
    private String resName;
    @Column(name="res_loc")
    private String resLoc;
    @Column(name="res_rating")
    private double resRating ;
    
    @OneToMany
    //@JsonIgnore
    private List<Owner> owner3;
    
//    @ManyToMany
  //  private ArrayList<FoodItems> fooditems;
    @ManyToMany(targetEntity = FoodItems.class, cascade = { CascadeType.ALL })
    private List<FoodItems> fooditems;
}
