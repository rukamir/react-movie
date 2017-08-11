package com.allstate.compozed.Movies;

import com.allstate.compozed.Movies.models.MovieModel;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<MovieModel, Long> {

}
