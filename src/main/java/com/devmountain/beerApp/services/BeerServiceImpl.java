package com.devmountain.beerApp.services;

import com.devmountain.beerApp.dtos.BeerDto;
import com.devmountain.beerApp.entities.Beer;
import com.devmountain.beerApp.entities.Pack;
import com.devmountain.beerApp.repositories.BeerRepository;
import com.devmountain.beerApp.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private PackRepository packRepository;

    @Override
    @Transactional
    public List<String> addBeer(BeerDto beerDto){
        List<String> response = new ArrayList<>();
        Beer beer = new Beer(beerDto);
        beerRepository.saveAndFlush(beer);
        response.add("Successfully added beer");
        return response;
    }

    @Override
    public List<BeerDto> getAllBeers(){
        List<Beer> beerList = beerRepository.findAll();
        return beerList.stream().map(BeerDto::new).collect(Collectors.toList());
    }

    @Override
    public List<BeerDto> getBeersByPack(Long packId){
        Optional<Pack> packOptional = packRepository.findById(packId);
        if(packOptional.isPresent()){
            List<Beer> beerList = beerRepository.findAllByPack(packOptional.get().getId());
            return beerList.stream().map(BeerDto::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
