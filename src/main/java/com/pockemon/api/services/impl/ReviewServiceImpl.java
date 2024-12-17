package com.pockemon.api.services.impl;

import com.pockemon.api.dto.ReviewDTO;
import com.pockemon.api.entities.Pokemon;
import com.pockemon.api.entities.Review;
import com.pockemon.api.exceptions.PokemonNotFoundException;
import com.pockemon.api.exceptions.ReviewNotFoundException;
import com.pockemon.api.repositories.PokemonRepository;
import com.pockemon.api.repositories.ReviewRepository;
import com.pockemon.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReviewServiceImpl implements ReviewService {


    private ReviewRepository reviewRepository;
    private PokemonRepository pokemonRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository) {
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public ReviewDTO createReview(int pokemonId, ReviewDTO reviewDTO) {
        Review review = fromDTO(reviewDTO);

        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new PokemonNotFoundException("No pokemon found"));

        review.setPokemon(pokemon);

        Review newReview = reviewRepository.save(review);

        return  mapToDTO(newReview);
    }

    @Override
    public List<ReviewDTO> getReviewByPokemonId(int id) {
        List<Review> reviewList = reviewRepository.findByPokemonId(id);

        return reviewList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(int reviewId, int pokemonId) {
        // first find the pokemon
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new PokemonNotFoundException("No pokemon was found"));

        // find review by id
        Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("No review found"));

        //checking if the pokemon Id matches
        if(review.getPokemon().getId() != pokemon.getId()){
            throw  new ReviewNotFoundException("This review does not belong to this pokemon");
        }

        return  mapToDTO(review);

    }

    @Override
    public ReviewDTO updateReview(int pokemonId, int reviewId, ReviewDTO reviewDTO) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new PokemonNotFoundException("No pokemon was found"));

        // find review by id
        Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("No review found"));

        //checking if the pokemon Id matches
        if(review.getPokemon().getId() != pokemon.getId()){
            throw  new ReviewNotFoundException("This review does not belong to this pokemon");
        }

        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setStarts(reviewDTO.getStarts());

        Review updatedReview = reviewRepository.save(review);

        return mapToDTO(updatedReview);
    }

    @Override
    public void deleteReview(int pokemonId, int reviewId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new PokemonNotFoundException("No pokemon was found"));

        // find review by id
        Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new ReviewNotFoundException("No review found"));

        //checking if the pokemon Id matches
        if(review.getPokemon().getId() != pokemon.getId()){
            throw  new ReviewNotFoundException("This review does not belong to this pokemon");
        }

        reviewRepository.delete(review);
    }

    private ReviewDTO mapToDTO(Review review){
            ReviewDTO reviewDTO = new ReviewDTO();

            reviewDTO.setId(review.getId());
            reviewDTO.setTitle(review.getTitle());
            reviewDTO.setContent(review.getContent());
            reviewDTO.setStarts(review.getStarts());

            return reviewDTO;
    }


    private Review fromDTO(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setTitle(reviewDTO.getTitle());
        review.setContent(reviewDTO.getContent());
        review.setStarts(reviewDTO.getStarts());
        return review;
    }
}
