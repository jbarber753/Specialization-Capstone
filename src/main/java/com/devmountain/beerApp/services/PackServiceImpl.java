package com.devmountain.beerApp.services;

import com.devmountain.beerApp.dtos.PackDto;
import com.devmountain.beerApp.entities.Beer;
import com.devmountain.beerApp.entities.Pack;
import com.devmountain.beerApp.entities.User;
import com.devmountain.beerApp.repositories.BeerRepository;
import com.devmountain.beerApp.repositories.PackRepository;
import com.devmountain.beerApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackServiceImpl implements PackService {

    @Autowired
    private PackRepository packRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BeerRepository beerRepository;

    @Override
    @Transactional
    public List<String> addPack(Long userId) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findById(userId);
        Pack pack = new Pack();
        userOptional.ifPresent(pack::setUser);
        packRepository.saveAndFlush(pack);
        response.add("Pack created");
        return response;
    }

    @Override
    public List<String> addBeerToPack(Long packId, Long beerId){
        List<String> response = new ArrayList<>();
        Optional<Pack> packOptional = packRepository.findById(packId);
        Optional<Beer> beerOptional = beerRepository.findById(beerId);
        packOptional.ifPresent(pack -> {
            beerOptional.ifPresent(beer -> {
                beer.getPackList().add(pack);
                pack.getBeerList().add(beer);
                beerRepository.saveAndFlush(beer);
                packRepository.saveAndFlush(pack);
            });
            response.add("Beer added to pack!");
        });
        return response;
    }

    @Override
    public void removeBeerFromPack(Long packId, Long beerId){
        Optional<Pack> packOptional = packRepository.findById(packId);
        Optional<Beer> beerOptional = beerRepository.findById(beerId);
        packOptional.ifPresent(pack -> {
            beerOptional.ifPresent(beer -> {
                beer.getPackList().remove(pack);
                pack.getBeerList().remove(beer);
                beerRepository.saveAndFlush(beer);
                packRepository.saveAndFlush(pack);
            });
        });
    }

    @Override
    public List<PackDto> getPacksByUser(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Pack> packList = packRepository.findAllByUserEquals(userOptional.get());
            return packList.stream().map(PackDto::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
