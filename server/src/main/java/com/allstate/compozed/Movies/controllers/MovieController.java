package com.allstate.compozed.Movies.controllers;

import com.allstate.compozed.Movies.models.MovieModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
final class MovieController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseCall() {
        return "Success";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<MovieModel> getMovies() {
        ArrayList<MovieModel> empty = new ArrayList<>();
        return empty;
    }
}
