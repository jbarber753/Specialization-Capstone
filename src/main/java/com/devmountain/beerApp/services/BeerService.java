package com.devmountain.beerApp.services;

import com.devmountain.beerApp.dtos.BeerDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BeerService {
    @Transactional
    List<String> addBeer(BeerDto beerDto);

    List<BeerDto> getAllBeers();
}
