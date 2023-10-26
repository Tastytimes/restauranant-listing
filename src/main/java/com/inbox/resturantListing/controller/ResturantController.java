package com.inbox.resturantListing.controller;


import com.inbox.resturantListing.dto.ResturantDto;
import com.inbox.resturantListing.entity.Resturant;
import com.inbox.resturantListing.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/restaurant")
@CrossOrigin
public class ResturantController {
    @Autowired
    ResturantService resturantService;

    @GetMapping("/all-restaurants")
    public ResponseEntity<List<ResturantDto>> fetchAllRestaurants(){
        List<ResturantDto> allResturants = resturantService.findAllResturants();
        return new ResponseEntity<>(allResturants, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<ResturantDto> addResturant(@RequestBody ResturantDto requestMap){
        ResturantDto restauranantAdded = resturantService.addRestaurant(requestMap);
        return new ResponseEntity<>(restauranantAdded, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResturantDto> updateRestaurant(@RequestParam String restId, @RequestBody Resturant requestMap){
        ResturantDto rest = resturantService.updateRestaurant(restId,requestMap);
        return new ResponseEntity<ResturantDto>(rest, HttpStatus.OK);
    }

    @GetMapping("/rest-by-id/{id}")
    public ResponseEntity<Resturant> getRestById(@PathVariable Integer id){
        Resturant rest = resturantService.findRestaurantById(id);
        return new ResponseEntity<Resturant>(rest, HttpStatus.OK);
    }
}
