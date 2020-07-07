package com.clayn.springtest.service;

import com.clayn.springtest.dtos.MovieDTO;
import com.clayn.springtest.model.Movie;
import com.clayn.springtest.repository.DirectorRepository;
import com.clayn.springtest.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Movie insertMovie(Movie movie, Integer directorId) {
        if (movieRepository.findMovieByTitle(movie.getTitle()).isPresent()) {
            log.info("Movie with title '" + movie.getTitle() + "' already exists.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie with this title already exists.");
        }
        directorRepository.findById(directorId).ifPresent(director -> {
            movie.setDirector(director);
            movieRepository.save(movie);
        });
        return movie;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO getMovies(PageRequest pageRequest) {
        Page<Movie> moviePages = movieRepository.findAll(pageRequest);
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovies(moviePages.getContent());
        movieDTO.setEmpty(moviePages.isEmpty());
        movieDTO.setLast(moviePages.isLast());
        movieDTO.setPagesCount(moviePages.getTotalPages());
        movieDTO.setTotalElements(moviePages.getNumberOfElements());
        return movieDTO;
    }
}
