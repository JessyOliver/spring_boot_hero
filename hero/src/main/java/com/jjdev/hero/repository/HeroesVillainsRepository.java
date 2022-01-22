package com.jjdev.hero.repository;

import com.jjdev.hero.entity.HeroesVillainsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroesVillainsRepository extends JpaRepository<HeroesVillainsEntity, Integer>,
        JpaSpecificationExecutor<HeroesVillainsEntity> {

    Optional<HeroesVillainsEntity> findByName(String name);

}
