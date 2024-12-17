package com.pockemon.api.services.impl;

import com.pockemon.api.dto.PokemonDTO;
import com.pockemon.api.entities.Pokemon;
import com.pockemon.api.exceptions.PokemonNotFoundException;
import com.pockemon.api.repositories.PokemonRepository;
import com.pockemon.api.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO){
        Pokemon pokemon =  new Pokemon();

        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDTO pokemonResponse =  new PokemonDTO();

        pokemon.setId(newPokemon.getId());
        pokemon.setName(newPokemon.getName());
        pokemon.setType(newPokemon.getType());

        return  null;
    }


    @Override
    public List<PokemonDTO> getAllPokemon(){
        List<Pokemon> pokemonList = pokemonRepository.findAll();

        return pokemonList.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    @Override
    public  PokemonDTO getPokemonById(int id){
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("Pokemon couldn't be found "));

        return mapToDto(pokemon);
    }

    @Override
    public PokemonDTO updatePokemon(PokemonDTO pokemonDTO, int id){
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("pokemon not found"));

        pokemon.setType(pokemonDTO.getType());
        pokemon.setName(pokemonDTO.getName());

        Pokemon updatedPokemon =  pokemonRepository.save(pokemon);

        return mapToDto(updatedPokemon);
    }


    public void deletePokemon(int id){
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("pokemon not found"));
        pokemonRepository.delete(pokemon);
    }

    // mapping from pokemon to pokemon dto
    private PokemonDTO mapToDto(Pokemon pokemon){
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setType(pokemon.getType());
        pokemonDTO.setId(pokemon.getId());
        return pokemonDTO;
    }


    private Pokemon fromDto(PokemonDTO pokemonDTO){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonDTO.getId());
        pokemon.setName(pokemon.getName());
        pokemon.setType(pokemon.getType());
        return pokemon;
    }
}
