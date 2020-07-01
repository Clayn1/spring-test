package com.clayn.springtest.repository;

import com.clayn.springtest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByTitle(String title);
}

