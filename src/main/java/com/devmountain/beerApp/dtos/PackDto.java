package com.devmountain.beerApp.dtos;

import com.devmountain.beerApp.entities.Pack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackDto implements Serializable {
    private Long id;

    private String active = "true";

    private UserDto userDto;

    private List<BeerDto> beerDtoList = new ArrayList<BeerDto>();

    public PackDto(Pack pack){
        if (pack.getId() != null){
            this.id = pack.getId();
        }
        if (pack.getActive() != null){
            this.active = pack.getActive();
        }
    }
}
