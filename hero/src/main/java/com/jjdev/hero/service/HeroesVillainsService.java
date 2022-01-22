package com.jjdev.hero.service;

import com.jjdev.hero.dto.HeroesVillainsDto;
import com.jjdev.hero.entity.HeroesVillainsEntity;
import com.jjdev.hero.error.HeroesVillainsError;
import com.jjdev.hero.exception.HeroesVillainsException;
import com.jjdev.hero.mapper.HeroesVillainsMapper;
import com.jjdev.hero.repository.HeroesVillainsRepository;
import com.jjdev.hero.request.HeroesVillainsRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HeroesVillainsService {

    @Autowired
    private HeroesVillainsRepository  heroesVillainsRepository;

    public List<HeroesVillainsDto> getAll(){

        List<HeroesVillainsDto> heroesVillainsList = HeroesVillainsMapper.toDtoList(heroesVillainsRepository.findAll());

        if (heroesVillainsList.size() != 0){

            return heroesVillainsList;
        }

        throw new HeroesVillainsException(new HeroesVillainsError("NOT_FOUND",
                HttpStatus.NOT_FOUND.value(),
                "Mutantes não encontrados."));
    }

    public HeroesVillainsDto getOne(String name) throws HeroesVillainsException{

        Optional<HeroesVillainsEntity> heroesVillainsEntity = heroesVillainsRepository.findByName(name);

        if (heroesVillainsEntity.isPresent()){
            return HeroesVillainsMapper.toDto(heroesVillainsEntity.get());
        }
            throw new HeroesVillainsException(new HeroesVillainsError(
                    "NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Mutante " + name + " não encontrado!"
            ));
    }


    public HeroesVillainsDto add(HeroesVillainsRequest mutants){
        return HeroesVillainsMapper.toDto(heroesVillainsRepository
                .save(HeroesVillainsMapper.requestToEntity(mutants)));
    }

    public HeroesVillainsDto update(String name, HeroesVillainsRequest request)
        throws HeroesVillainsException{

        Optional<HeroesVillainsEntity>  heroesVillainsEntity = heroesVillainsRepository.findByName(name);

        if (heroesVillainsEntity.isPresent()){

            heroesVillainsEntity.get().setName(request.getName());
            heroesVillainsEntity.get().setCreationDate(request.getCreationDate());
            heroesVillainsEntity.get().setPowers(request.getPowers());
            heroesVillainsEntity.get().setImg(request.getImg());
            heroesVillainsEntity.get().setTipo(request.getTipo());
            heroesVillainsEntity.get().setFraquesa(request.getFraquesa());
            heroesVillainsEntity.get().setEnemy(request.getEnemy());
            heroesVillainsEntity.get().setColors(request.getColors());
            return HeroesVillainsMapper.toDto(heroesVillainsRepository.save(heroesVillainsEntity.get()));
        }

            throw  new HeroesVillainsException(new HeroesVillainsError(
                    "NOT_FOUND",
                    HttpStatus.NOT_FOUND.value(),
                    "Mutante " + name + " não encontrado!"
            ));
    }

    public String delete(String name){

        Optional<HeroesVillainsEntity> entity = heroesVillainsRepository.findByName(name);

        if (entity.isPresent()){
            heroesVillainsRepository.delete(entity.get());
            return  name + " Deletado!";
        }

        throw new HeroesVillainsException(new HeroesVillainsError(
                "NOT FOUND",
                HttpStatus.NOT_FOUND.value(),
                "Mutante " + name + " não encontrado!"
        ));

    }

}
