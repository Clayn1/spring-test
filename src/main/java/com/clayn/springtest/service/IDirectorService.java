package com.clayn.springtest.service;

import com.clayn.springtest.model.Director;

import java.util.List;

public interface IDirectorService {
    Director insertDirector(Director director);
    List<Director> getAllDirectors();
}
