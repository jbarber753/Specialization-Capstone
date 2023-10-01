package com.devmountain.beerApp.dtos;

import com.devmountain.beerApp.entities.Pack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackDto implements Serializable {
    private Long id;

    private UserDto userDto;

    private ArrayList<BeerDto> beerDtoArrayList = new ArrayList<BeerDto>();

    public PackDto(Pack pack){
        if (pack.getId() != null){
            this.id = pack.getId();
        }
    }
}
