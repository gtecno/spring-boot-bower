/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.spring.repository;

import co.agileventure.cloud.spring.entidad.Movie;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author DESARROLLO 13
 */
public interface MovieRepository extends ElasticsearchRepository< Movie, Long> {

    public List< Movie> findByName(String name);

    public List< Movie> findByRatingBetween(Double beginning, Double end);
}
