/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Car;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author Albin
 */
@Stateless
public class CarDAO extends AbstractDAO<Car> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;

    public CarDAO() {
        super(Car.class);
    }

    public List<Car> findCarsMatchingName() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
