package com.allstate.compozed.Movies.controllers;

import com.allstate.compozed.Movies.AppRepository;
import com.allstate.compozed.Movies.models.MovieModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
final class MovieController {
    private final AppRepository repository;

    MovieController(AppRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/movies")
    public ResponseEntity<MovieModel> create(@RequestBody final MovieModel model) {
        final MovieModel appModel = repository.save(model);
        System.out.println("hey boo boo *********************");
        return new ResponseEntity<>(appModel, OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseCall() {
        return "Success";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseStatus(OK)
    public ArrayList<MovieModel> getMovies() {
        ArrayList<MovieModel> empty = new ArrayList<>();
        return empty;
    }
}
