package com.jjdev.hero.exception;

import com.jjdev.hero.error.HeroesVillainsError;
import lombok.Getter;

@Getter
public class HeroesVillainsException extends RuntimeException{

    private HeroesVillainsError heroesVillainsError;

    public HeroesVillainsException(HeroesVillainsError heroesVillainsError){
        super();
        this.heroesVillainsError = heroesVillainsError;
    }
}
