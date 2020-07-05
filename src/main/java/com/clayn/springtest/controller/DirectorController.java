package com.clayn.springtest.controller;

import com.clayn.springtest.model.Director;
import com.clayn.springtest.service.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/director")
public class DirectorController {

    @Autowired
    private IDirectorService directorService;

    @GetMapping
    public List<Director> getDirectors(){
        return directorService.getAllDirectors();
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director){
        return directorService.insertDirector(director);
    }
}
