/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.spring.resource;

import co.agileventure.cloud.spring.boot.bower.BowerAplicationInit;
import co.agileventure.cloud.spring.entidad.Genre;
import co.agileventure.cloud.spring.entidad.Movie;
import co.agileventure.cloud.spring.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 *
 * @author DESARROLLO 13
 */
@RestController
@RequestMapping("/Movie")
public class MovieResource {
     @Autowired
    private MovieService movieService;

    private static final Logger logger = LoggerFactory.getLogger(BowerAplicationInit.class);

// add star wars and
// princess bride as a movie
// to elastic search
    private void addSomeMovies() {
        Movie starWars = getFirstMovie();
        movieService.addMovie(starWars);

        Movie princessBride = getSecondMovie();
        movieService.addMovie(princessBride);
    }

    private Movie getSecondMovie() {
        Movie secondMovie = new Movie();
        secondMovie.setId("2");
        secondMovie.setRating(8.4d);
        secondMovie.setName("The Princess Bride");

        List < Genre >  princessPrideGenre = new ArrayList < Genre >();
        princessPrideGenre.add(new Genre("ACTION"));
        princessPrideGenre.add(new Genre("ROMANCE"));
        secondMovie.setGenre(princessPrideGenre);

        return secondMovie;
    }


    private Movie getFirstMovie() {
        Movie firstMovie = new Movie();
        firstMovie.setId("1");
        firstMovie.setRating(9.6d);
        firstMovie.setName("Star Wars");

        List < Genre >  starWarsGenre = new ArrayList < Genre >();
        starWarsGenre.add(new Genre("ACTION"));
        starWarsGenre.add(new Genre("SCI_FI"));
        firstMovie.setGenre(starWarsGenre);

        return firstMovie;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void correrElastich() throws Exception {
        addSomeMovies();
        // We indexed star wars and pricess bride to our movie
        // listing in elastic search

        //Lets query if we have a movie with Star Wars as name
        List < Movie > starWarsNameQuery = movieService.getByName("Star Wars");
        logger.info("Content of star wars name query is {}", starWarsNameQuery);

        //Lets query if we have a movie with The Princess Bride as name
        List < Movie >  brideQuery = movieService.getByName("The Princess Bride");
        logger.info("Content of princess bride name query is {}", brideQuery);


        //Lets query if we have a movie with rating between 6 and 9
        List < Movie >  byRatingInterval = movieService.getByRatingInterval(6d, 9d);
        logger.info("Content of Rating Interval query is {}", byRatingInterval);
    }
}
