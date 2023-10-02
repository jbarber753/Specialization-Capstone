package com.devmountain.beerApp.repositories;

import com.devmountain.beerApp.entities.Beer;
import com.devmountain.beerApp.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    @Query(value = "SELECT * FROM beers JOIN beer_packs ON beers.id = beer_packs.beer_id WHERE beer_packs.pack_id = :packId", nativeQuery = true)
    List<Beer> findAllByPack(@Param("packId") Long packId);
}
