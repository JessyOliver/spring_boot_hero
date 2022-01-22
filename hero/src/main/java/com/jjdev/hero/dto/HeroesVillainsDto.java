package com.jjdev.hero.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroesVillainsDto {

    private String name;

    private String creationDate;

    private String powers;

    private String img;

    private String tipo;

    private String fraquesa;

    private String enemy;

    private String colors;
}

