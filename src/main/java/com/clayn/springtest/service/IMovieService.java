package com.clayn.springtest.service;

import com.clayn.springtest.model.Movie;

import java.util.List;

public interface IMovieService {
    Movie insertMovie(Movie movie);

    Movie updateMovie(Movie movie);

    void deleteMovie(Integer id);

    List<Movie> getAllMovies();

}
