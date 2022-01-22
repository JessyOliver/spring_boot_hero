package com.jjdev.hero.entity;

import com.sun.istack.NotNull;
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
public class Heroes_Villains {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    private String creationDate;

    private String powers;

    @NotNull
    private String img;

    @NotNull
    private String tipo;

    private String fraquesa;

    @NotNull
    private String enemy;

    @NotNull
    private String colors;


}
