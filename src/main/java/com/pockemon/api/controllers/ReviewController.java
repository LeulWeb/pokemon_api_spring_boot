package com.pockemon.api.controllers;


import com.pockemon.api.dto.ReviewDTO;
import com.pockemon.api.entities.Review;
import com.pockemon.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/pokemons/{pokemonId}/review")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(value = "pokemonId") int pokemonId, @RequestBody ReviewDTO reviewDTO){
        return  new ResponseEntity<>(reviewService.createReview(pokemonId, reviewDTO), HttpStatus.CREATED);
    }


    @GetMapping("/pokemons/{pokemonId}/reviews")
    public List<ReviewDTO> getReviewsByPokemonId(@PathVariable(value = "pokemonId") int  pokemonId){
        return reviewService.getReviewByPokemonId(pokemonId);
    }

    @GetMapping("/pokemons/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable(value = "pokemonId") int pokemonId , @PathVariable int id ){
        ReviewDTO reviewDTO = reviewService.getReviewById(id, pokemonId);

        return ResponseEntity.ok(reviewDTO);
    }

    @PutMapping("/pokemons/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable(value = "pokemonId") int pokemonId, @PathVariable int id,@RequestBody ReviewDTO reviewDTO){
        ReviewDTO updatedReview = reviewService.updateReview(pokemonId, id, reviewDTO);
        return  new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/pokemons/{pokemonId}/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable(value = "pokemonId") int pokemonId, @PathVariable int id){
        reviewService.deleteReview(pokemonId, id);
        return new ResponseEntity<String>("Review is deleted successfully", HttpStatus.OK);
    }
}
