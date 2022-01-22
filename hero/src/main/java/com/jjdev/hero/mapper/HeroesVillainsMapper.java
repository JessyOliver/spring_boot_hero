package com.jjdev.hero.mapper;

import com.jjdev.hero.dto.HeroesVillainsDto;
import com.jjdev.hero.entity.HeroesVillainsEntity;
import com.jjdev.hero.request.HeroesVillainsRequest;

import java.util.List;
import java.util.stream.Collectors;

public class HeroesVillainsMapper {


    public static HeroesVillainsDto toDto(HeroesVillainsEntity entity){
        return HeroesVillainsDto.builder()
                .name(entity.getName())
                .creationDate(entity.getCreationDate())
                .powers(entity.getPowers())
                .img(entity.getImg())
                .tipo(entity.getTipo())
                .fraquesa(entity.getFraquesa())
                .enemy(entity.getEnemy())
                .colors(entity.getColors())
                .build();

    }

    public static List<HeroesVillainsDto> toDtoList(List<HeroesVillainsEntity> heroesVillainsEntitiesList){
        return heroesVillainsEntitiesList.stream().map(HeroesVillainsMapper::toDto)
                .collect(Collectors.toList());
    }

    public static HeroesVillainsEntity requestToEntity(HeroesVillainsRequest request){

        return HeroesVillainsEntity.builder()
                .name(request.getName())
                .creationDate(request.getCreationDate())
                .powers(request.getPowers())
                .img(request.getImg())
                .tipo(request.getTipo())
                .fraquesa(request.getFraquesa())
                .enemy(request.getEnemy())
                .colors(request.getColors())
                .build();
    }

}
