package com.pockemon.api.controllers;


import com.pockemon.api.dto.PokemonDTO;
import com.pockemon.api.entities.Pokemon;
import com.pockemon.api.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {


    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PokemonDTO>> getAllPokemons(){
        return new ResponseEntity<>(pokemonService.getAllPokemon(), HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public  ResponseEntity<PokemonDTO> getPokemon(@PathVariable int id){
        return  ResponseEntity.ok(pokemonService.getPokemonById(id));
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDTO> storePokemon(@RequestBody PokemonDTO pokemonDTO){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable int id, @RequestBody PokemonDTO pokemonDTO){
        PokemonDTO response = pokemonService.updatePokemon(pokemonDTO, id);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> destoryPokemon(@PathVariable int id){
        pokemonService.deletePokemon(id);

        return   new ResponseEntity<>("pokemon deleted", HttpStatus.OK);
    }
}
