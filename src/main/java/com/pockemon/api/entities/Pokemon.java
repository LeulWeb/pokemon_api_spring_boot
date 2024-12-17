package com.pockemon.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


//  the lombok will generate all the boring staff
@Data 
@Entity // this is entity and will be mapped to table
@AllArgsConstructor // lombok i need all args constructor
@NoArgsConstructor // lombok I need an empty constructor
public class Pokemon {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;


    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<Review>();

    // // constructor

    public Pokemon(){

    }

     public Pokemon(int id, String name, String type){
         this.id = id;
         this.name= name;
         this.type = type;
     }

     // getters

     public String getName(){
         return this.name;
     }

     public String getType(){
         return this.type;
     }

     public int getId(){
         return this.id;
     }

     // setters
    
     public void setName(String name){
         this.name = name;
     }

     public void setId(int id){
         this.id = id;
     }

     public void setType(String type){
         this.type = type;
     }
}
