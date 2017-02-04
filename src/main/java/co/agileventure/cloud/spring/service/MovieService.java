/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.spring.service;

import co.agileventure.cloud.spring.entidad.Movie;
import co.agileventure.cloud.spring.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO 13
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List < Movie >  getByName(String name) {
        return repository.findByName(name);
    }

    public List < Movie >  getByRatingInterval(Double beginning, Double end) {
        return repository.findByRatingBetween(beginning, end);
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }
}
