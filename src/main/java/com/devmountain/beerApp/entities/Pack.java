package com.devmountain.beerApp.entities;

import com.devmountain.beerApp.dtos.PackDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "packs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean isActive = true;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToMany(mappedBy = "packList")
    private List<Beer> beerList = new ArrayList<Beer>();

    public Pack(PackDto packDto){}
}
