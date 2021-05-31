package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name="owner3")
public class Owner {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="owner_id")
    private int ownerId;
    @Column(name="owner_name")
    private String ownerName;
//    @OneToOne
//    private Resturant resturant;
//    @ManyToOne
//   // @JsonIgnore
//    private Resturant resturant2;

}
