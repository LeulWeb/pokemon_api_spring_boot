package com.pockemon.api.repositories;


import com.pockemon.api.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
