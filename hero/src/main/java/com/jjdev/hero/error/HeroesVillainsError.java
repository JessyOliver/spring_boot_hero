package com.jjdev.hero.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroesVillainsError {

    private String message;

    private Integer httpCode;

    private String details;

    public HeroesVillainsError(String message, Integer httpCode, String details) {
        this.message = message;
        this.httpCode = httpCode;
        this.details = details;
    }
}
