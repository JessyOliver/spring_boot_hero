package com.jjdev.hero.controller;

import com.jjdev.hero.dto.HeroesVillainsDto;
import com.jjdev.hero.exception.HeroesVillainsException;
import com.jjdev.hero.request.HeroesVillainsRequest;
import com.jjdev.hero.response.BaseResponse;
import com.jjdev.hero.service.HeroesVillainsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mutants")
public class HeroesVillainsController {

    @Autowired
    private final HeroesVillainsService service;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<HeroesVillainsDto>>> getAll(){

        return ResponseEntity.ok(BaseResponse.<List<HeroesVillainsDto>>builder()
                        .httpCode(HttpStatus.OK.value())
                        .message("Retornando lista.")
                        .response(service.getAll())
                        .build()
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<BaseResponse<HeroesVillainsDto>> getByName(@PathVariable("name") String name) throws HeroesVillainsException {
        return ResponseEntity.ok(BaseResponse.<HeroesVillainsDto>builder()
                .httpCode(200)
                .response(service.getOne(name))
                .message("Mutante retornado com sucesso!!")
                .build()
        );

    }


    @PostMapping("/addmutant")
    public ResponseEntity<BaseResponse<HeroesVillainsDto>> add(@RequestBody HeroesVillainsRequest request){

        return ResponseEntity.ok(BaseResponse.<HeroesVillainsDto>builder()
                        .httpCode(HttpStatus.CREATED.value())
                        .message("Mutante Criado com sucesso!!")
                        .response(service.add(request))
                        .build()
        );
    }

    @PutMapping("editar/{name}")
    public ResponseEntity<BaseResponse<HeroesVillainsDto>> update(@RequestBody HeroesVillainsRequest request,
                                                                  @PathVariable("name") String name)
                                                                  throws HeroesVillainsException{

        return ResponseEntity.ok(BaseResponse.<HeroesVillainsDto>builder()
                        .httpCode(HttpStatus.OK.value())
                        .message( name + " atualizado com sucesso!!")
                        .response(service.update(name, request))
                        .build()
        );

    }

    @DeleteMapping("/{name}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable("name") String name){

        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .response( name + " apagado!")
                        .message(service.delete(name))
                        .httpCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
