package com.devmountain.beerApp.controllers;

import com.devmountain.beerApp.dtos.BeerDto;
import com.devmountain.beerApp.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/beers")
public class BeerController {
    @Autowired
    private BeerService beerService;

    @GetMapping("/beers")
    public List<BeerDto> getAllBeers(){return beerService.getAllBeers();}

    @PostMapping("/add")
    public List<String> addBeer(@RequestBody BeerDto beerDto){
        return beerService.addBeer(beerDto);}
}
