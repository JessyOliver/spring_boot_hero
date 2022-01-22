package com.jjdev.hero.entity;

import ch.qos.logback.core.joran.action.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "heroes_villains")
public class HeroesVillainsEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String creationDate;

    private String powers;

    private String img;

    private String tipo;

    private String fraquesa;

    private String enemy;

    private String colors;

}
