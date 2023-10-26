package com.inbox.resturantListing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResturantDto {

    private Integer id;
    private String name;
    private String city;
    private String description;

//    public ResturantDto(Integer id, String name, String city, String description) {
//        this.id = id;
//        this.name = name;
//        this.city = city;
//        this.description = description;
//    }
//
//    public ResturantDto(){
//
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "ResturantDto{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", city='" + city + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
