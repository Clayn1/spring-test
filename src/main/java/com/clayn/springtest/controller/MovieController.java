package com.clayn.springtest.controller;

import com.clayn.springtest.model.Movie;
import com.clayn.springtest.service.IMovieService;
import com.clayn.springtest.validation.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;
    @Autowired
    private MovieValidator movieValidator;

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{directorId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody @Valid Movie movie, @PathVariable Integer directorId){
        return movieService.insertMovie(movie, directorId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
        movie.setId(id);
        return movieService.updateMovie(movie);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(movieValidator);
    }
}
