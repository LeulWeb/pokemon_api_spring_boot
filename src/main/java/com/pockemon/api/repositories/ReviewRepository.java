package com.pockemon.api.repositories;

import com.pockemon.api.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

   // query builder
    List<Review> findByPokemonId(int pokemonId);
}
