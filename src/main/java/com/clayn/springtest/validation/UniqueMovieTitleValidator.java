package com.clayn.springtest.validation;

import com.clayn.springtest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueMovieTitleValidator implements ConstraintValidator<UniqueMovieTitle, String> {

   @Autowired
   private MovieRepository movieRepository;

   @Override
   public boolean isValid(String title, ConstraintValidatorContext context) {
      return true;
      // return  (title != null && movieRepository.findMovieByTitle(title) == null);
   }
}
