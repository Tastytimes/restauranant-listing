package com.inbox.resturantListing.service;

import com.inbox.resturantListing.dto.ResturantDto;
import com.inbox.resturantListing.entity.Resturant;
import com.inbox.resturantListing.repo.ResturantRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ResturantService {

    @Autowired
    ResturantRepo restRepo;

    public List<ResturantDto> findAllResturants() {
        List<Resturant> resturants = restRepo.findAll();
        List<ResturantDto> restDto = new ArrayList<>();
        for(Resturant resturant: resturants) {
            ResturantDto restDto1 = new ResturantDto();
            restDto1.setId(resturant.getId());
            restDto1.setName(resturant.getName());
            restDto1.setCity(resturant.getCity());
            restDto1.setDescription(resturant.getDescription());
            restDto.add(restDto1);
        }
        return restDto;
    }

    public ResturantDto addRestaurant(ResturantDto requestMap) {
        log.info("requestmap {}", requestMap);
        Resturant rest = new Resturant();
        ResturantDto dto = new ResturantDto();
        rest.setName(requestMap.getName());
        rest.setCity(requestMap.getCity());
        rest.setDescription(requestMap.getDescription());

       Resturant resp =  restRepo.save(rest);
        dto.setName(resp.getName());
        dto.setCity(resp.getCity());
        dto.setDescription(resp.getDescription());
        dto.setId(resp.getId());

       return dto;
    }

    public ResturantDto updateRestaurant(String id, Resturant requestMap) {
        Optional<Resturant> resturant1 = restRepo.findById(Integer.parseInt(id));
        ResturantDto dto = new ResturantDto();
        Resturant resturant = resturant1.orElse(null);
        resturant.setName(requestMap.getName());
        resturant.setCity(requestMap.getCity());
        resturant.setDescription(requestMap.getDescription());
        resturant.setId(Integer.parseInt(id));
        restRepo.save(resturant);
        dto.setName(resturant.getName());
        dto.setCity(resturant.getCity());
        dto.setDescription(resturant.getDescription());
        dto.setId(resturant.getId());
        return  dto;

    }

    public Resturant findRestaurantById(Integer id) {
        Optional<Resturant> optionalRest = restRepo.findById(id);
        Resturant rest = optionalRest.orElse(null);
        return rest;
    }
}
