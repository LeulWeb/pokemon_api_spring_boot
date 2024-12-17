package com.pockemon.api.services;

import com.pockemon.api.dto.ReviewDTO;
import com.pockemon.api.entities.Review;

import java.util.List;

public interface ReviewService {

    ReviewDTO createReview(int pokemonId, ReviewDTO reviewDTO);

    List<ReviewDTO> getReviewByPokemonId(int  id);

    ReviewDTO getReviewById(int reviewId, int pokemonId);

    ReviewDTO  updateReview(int pokemonId, int reviewId, ReviewDTO reviewDTO);

    void deleteReview(int pokemonId, int reviewId);
}
