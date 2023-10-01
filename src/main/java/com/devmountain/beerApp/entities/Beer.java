package com.devmountain.beerApp.entities;

import com.devmountain.beerApp.dtos.BeerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table(name = "beers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String variety;

    @Column
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "beer_packs",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "pack_id")
    )
    private ArrayList<Pack> packArrayList = new ArrayList<Pack>();

    public Beer(BeerDto beerDto){
        if(beerDto.getName() != null){
            this.name = beerDto.getName();
        }
        if(beerDto.getVariety() != null){
            this.variety = beerDto.getVariety();
        }
        if(beerDto.getPrice() != null){
            this.price = beerDto.getPrice();
        }
    }
}
