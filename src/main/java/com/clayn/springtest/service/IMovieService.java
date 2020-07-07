package com.clayn.springtest.service;

import com.clayn.springtest.dtos.MovieDTO;
import com.clayn.springtest.model.Movie;
import org.springframework.data.domain.PageRequest;

public interface IMovieService {
    Movie insertMovie(Movie movie, Integer directorId);

    Movie updateMovie(Movie movie);

    void deleteMovie(Integer id);

    MovieDTO getMovies(PageRequest pageRequest);

}
