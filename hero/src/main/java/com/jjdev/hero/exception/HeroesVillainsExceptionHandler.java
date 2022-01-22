package com.jjdev.hero.exception;

import com.jjdev.hero.error.HeroesVillainsError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HeroesVillainsExceptionHandler {


    @ExceptionHandler(HeroesVillainsException.class)
    public ResponseEntity<HeroesVillainsError> handleheroesVillainsException(HeroesVillainsException e) {
        return ResponseEntity.status(e.getHeroesVillainsError().getHttpCode()).body(e.getHeroesVillainsError());
    }



}
