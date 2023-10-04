package com.devmountain.beerApp.controllers;

import com.devmountain.beerApp.dtos.PackDto;
import com.devmountain.beerApp.services.BeerService;
import com.devmountain.beerApp.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/packs")
public class PackController {
    @Autowired
    PackService packService;

    @Autowired
    BeerService beerService;

    @PostMapping("/add/{userId}")
    public List<String> addPack(@PathVariable Long userId){
        return packService.addPack(userId);
    }

    @PostMapping("/addbeer/{packId}/{beerId}")
    public List<String> addBeerToPack(@PathVariable Long packId, @PathVariable Long beerId){
        return packService.addBeerToPack(packId, beerId);
    }

    @DeleteMapping("/removebeer/{packId}/{beerId}")
    public void removeBeerFromPack(@PathVariable Long packId, @PathVariable Long beerId){
        packService.removeBeerFromPack(packId, beerId);
    }

    @GetMapping("/getpacks/{userId}")
    public List<PackDto> getPacksByUser(@PathVariable Long userId){
        return packService.getPacksByUser(userId);
    }
}
