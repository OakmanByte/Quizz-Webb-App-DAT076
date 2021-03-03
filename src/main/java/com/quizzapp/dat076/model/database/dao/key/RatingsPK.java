/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author anton Composite key for Ratings since it needs the quiz id aswell
 */
@Data
public class RatingsPK implements Serializable {

    private int category;
    private int id;

}
