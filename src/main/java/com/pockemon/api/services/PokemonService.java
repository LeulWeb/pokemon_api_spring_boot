package com.pockemon.api.services;

import com.pockemon.api.dto.PokemonDTO;

import java.util.List;

public interface PokemonService {
    PokemonDTO createPokemon(PokemonDTO pokemonDTO);

    List<PokemonDTO> getAllPokemon();

    PokemonDTO getPokemonById(int id);

    PokemonDTO updatePokemon(PokemonDTO pokemonDTO, int id);

    void deletePokemon(int id);
}
