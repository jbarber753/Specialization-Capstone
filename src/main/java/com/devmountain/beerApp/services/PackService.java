package com.devmountain.beerApp.services;

import com.devmountain.beerApp.dtos.PackDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PackService {
    @Transactional
    void addPack(PackDto packDto, Long userId);

    void addBeerToPack(Long packId, Long beerId);

    void removeBeerFromPack(Long packId, Long beerId);

    List<PackDto> getPacksByUser(Long userId);
}
