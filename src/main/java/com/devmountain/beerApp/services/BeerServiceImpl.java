package com.devmountain.beerApp.services;

import com.devmountain.beerApp.dtos.BeerDto;
import com.devmountain.beerApp.entities.Beer;
import com.devmountain.beerApp.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    private BeerRepository beerRepository;

    @Override
    @Transactional
    public List<String> addBeer(BeerDto beerDto){
        List<String> response = new ArrayList<>();
        Beer beer = new Beer(beerDto);
        beerRepository.saveAndFlush(beer);
        response.add("Successfully added beer");
        return response;
    }
}
