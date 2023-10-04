package com.devmountain.beerApp.dtos;

import com.devmountain.beerApp.entities.Beer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto implements Serializable {
    private Long id;

    private String name;

    private String image;

    private String price;

    private List<PackDto> packDtoList = new ArrayList<PackDto>();

    public BeerDto(Beer beer){
        if (beer.getId() != null){
            this.id = beer.getId();
        }
        if (beer.getName() != null){
            this.name = beer.getName();
        }
        if (beer.getImage() != null){
            this.image = beer.getImage();
        }
        if (beer.getPrice() != null){
            this.price = beer.getPrice();
        }
    }
}
