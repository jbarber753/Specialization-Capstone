package com.devmountain.beerApp.repositories;

import com.devmountain.beerApp.entities.Pack;
import com.devmountain.beerApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Pack> findAllByUserEquals(User user);
}
