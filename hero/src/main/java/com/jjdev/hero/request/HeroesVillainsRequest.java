package com.jjdev.hero.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeroesVillainsRequest {

    private String name;

    private String creationDate;

    private String powers;

    private String img;

    private String tipo;

    private String fraquesa;

    private String enemy;

    private String colors;

}
