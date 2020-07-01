package com.clayn.springtest.validation;

import com.clayn.springtest.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;
        char firstChat = movie.getTitle().charAt(0);
        if (firstChat == movie.getTitle().toLowerCase().charAt(0)){
            errors.rejectValue("title", "First letter should be capital", "First letter should be capital");
        }
    }
}
