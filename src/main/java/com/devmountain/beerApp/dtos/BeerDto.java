package com.devmountain.beerApp.dtos;

import com.devmountain.beerApp.entities.Beer;
import com.devmountain.beerApp.entities.Pack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto implements Serializable {
    private Long id;

    private String name;

    private String variety;

    private BigDecimal price;

    private ArrayList<PackDto> packDtoArrayList = new ArrayList<PackDto>();

    public BeerDto(Beer beer){
        if (beer.getId() != null){
            this.id = beer.getId();
        }
        if (beer.getName() != null){
            this.name = beer.getName();
        }
        if (beer.getVariety() != null){
            this.variety = beer.getVariety();
        }
        if (beer.getPrice() != null){
            this.price = beer.getPrice();
        }
    }
}
