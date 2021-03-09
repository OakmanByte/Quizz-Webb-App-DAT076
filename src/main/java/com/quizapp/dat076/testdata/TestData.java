/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.testdata;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.dao.LeaderboardDAO;
import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Leaderboard;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizapp.dat076.model.entity.Ratings;
import com.quizzapp.dat076.model.database.dao.key.LeaderboardPK;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Temporary class for initilization each run of the program with finished data in the database such as accounts, quizzes, categories, questions etc. Used for work not meant for final product.
 * @author Rebecka
 */

@Startup
@Singleton
public class TestData {

  /*  @EJB
    private LeaderboardDAO leaderboardDAO;

    @EJB
    private AccountDAO accountDAO;

    @EJB
    private QuizDAO quizDAO;

    @EJB
    private QuestionDAO questionDAO;

    @EJB
    private CategoryDAO categoryDAO;

    @EJB
    private RatingsDAO ratingsDAO;

    Account acc1;
    Account acc2;
    Account acc3;
    Account acc4;

    Quiz quiz1;
    Quiz quiz2;
    Quiz quiz3;
    Quiz quiz4;

    Category cat1;
    Category cat2;
    Category cat3;
    Category cat4;
    Category cat5;
    Category cat6;
    Category cat7;

    Leaderboard lead1;
    Leaderboard lead2;
    Leaderboard lead3;
    Leaderboard lead4;
    Leaderboard lead5;
    Leaderboard lead6;
    Leaderboard lead7;
    Leaderboard lead8;
    Leaderboard lead9;

    Question q1_1;
    Question q1_2;
    Question q2_1;
    Question q2_2;
    Question q3_1;
    Question q3_2;
    Question q4_1;
    Question q4_2;
    Question q4_3;

    Ratings rat1;
    Ratings rat2;
    Ratings rat3;
    Ratings rat4;
    Ratings rat5;
    Ratings rat6;

    @PostConstruct
    public void init() {
        acc1 = new Account("Rebecka", "rebecka@me.com", "psgjsg", "user", "Science", 0, null, null);
        acc2 = new Account("Emma", "reemma@me.com", "psdsgjsg", "user", "Science", 0, null, null);
        acc3 = new Account("AntonE", "antone@me.com", "psgsdfjsg", "user", "Science", 0, null, null);
        acc4 = new Account("Albin", "albin@me.com", "password", "user", "Science", 22, null, null);

        accountDAO.create(acc1);
        accountDAO.create(acc2);
        accountDAO.create(acc3);
        accountDAO.create(acc4);

        cat1 = new Category("Animals");
        cat2 = new Category("Geography");
        cat3 = new Category("Math");
        cat4 = new Category("General Knowledge");
        cat5 = new Category("Science");
        cat6 = new Category("Movies");
        cat7 = new Category("Space");

        categoryDAO.create(cat1);
        categoryDAO.create(cat2);
        categoryDAO.create(cat3);
        categoryDAO.create(cat4);
        categoryDAO.create(cat5);
        categoryDAO.create(cat6);
        categoryDAO.create(cat7);

        quiz1 = new Quiz("Such Amaze", acc1, cat1);
        quiz2 = new Quiz("Very Much", acc2, cat2);
        quiz3 = new Quiz("Best Quiz", acc2, cat3);
        quiz4 = new Quiz("Space Quiz", acc4, cat7);

        quizDAO.create(quiz1);
        quizDAO.create(quiz2);
        quizDAO.create(quiz3);
        quizDAO.create(quiz4);
<<<<<<< HEAD
/*
        pk1 = new LeaderboardPK(acc1.getUsername(), quiz1.getId());
        pk2 = new LeaderboardPK(acc1.getUsername(), quiz2.getId());
        pk3 = new LeaderboardPK(acc1.getUsername(), quiz3.getId());
        pk4 = new LeaderboardPK(acc2.getUsername(), quiz1.getId());
        pk5 = new LeaderboardPK(acc2.getUsername(), quiz2.getId());
        pk6 = new LeaderboardPK(acc2.getUsername(), quiz3.getId());
        pk7 = new LeaderboardPK(acc3.getUsername(), quiz1.getId());
        pk8 = new LeaderboardPK(acc3.getUsername(), quiz2.getId());
        pk9 = new LeaderboardPK(acc3.getUsername(), quiz3.getId());

        lead1 = new Leaderboard(pk1, acc1, quiz1, 100);
        lead2 = new Leaderboard(pk2, acc1, quiz2, 70);
        lead3 = new Leaderboard(pk3, acc1, quiz3, 30);
        lead4 = new Leaderboard(pk4, acc2, quiz1, 90);
        lead5 = new Leaderboard(pk5, acc2, quiz2, 60);
        lead6 = new Leaderboard(pk6, acc2, quiz3, 20);
        lead7 = new Leaderboard(pk7, acc3, quiz1, 80);
        lead8 = new Leaderboard(pk8, acc3, quiz2, 50);
        lead9 = new Leaderboard(pk9, acc3, quiz3, 10);
=======
        
        lead1 = new Leaderboard(acc1, quiz1, 100);
        lead2 = new Leaderboard(acc1, quiz2, 70);
        lead3 = new Leaderboard(acc1, quiz3, 30);
        lead4 = new Leaderboard(acc2, quiz1, 90);
        lead5 = new Leaderboard(acc2, quiz2, 60);
        lead6 = new Leaderboard(acc2, quiz3, 20);
        lead7 = new Leaderboard(acc3, quiz1, 80);
        lead8 = new Leaderboard(acc3, quiz2, 50);
        lead9 = new Leaderboard(acc3, quiz3, 10);
>>>>>>> main

        leaderboardDAO.create(lead1);
        leaderboardDAO.create(lead2);
        leaderboardDAO.create(lead3);
        leaderboardDAO.create(lead4);
        leaderboardDAO.create(lead5);
        leaderboardDAO.create(lead6);
        leaderboardDAO.create(lead7);
        leaderboardDAO.create(lead8);
        leaderboardDAO.create(lead9);

<<<<<<< HEAD
        q1_1 = new Question("How many legs does a dog have?", 1, "2", "4", "6", "8", 2, quiz1);
        q1_2 = new Question("How many legs does a duck have?", 2, "2", "4", "6", "8", 1, quiz1);
        q2_1 = new Question("What country is Florida in?", 3, "France", "Sweden", "USA", "UK", 3, quiz2);
        q2_2 = new Question("What country is Perth in?", 4, "New Zeland", "Indonesia", "India", "Australia", 4, quiz2);
        q3_1 = new Question("What is 2*3?", 5, "9", "6", "5", "8", 2, quiz3);
        q3_2 = new Question("What is 2^3?", 6, "9", "6", "5", "8", 4, quiz3); 
        q4_1 = new Question("Which planet is closest to the sun?", quiz4.getId(), "Pluto", "Venus", "Merkurius", "Mars", 3, quiz4);
        q4_2 = new Question("Which was the first country to send a human into space?", quiz4.getId(), "Sweden", "USSR", "USA", "East Germany", 2, quiz4);
        q4_3 = new Question("What were Buzz Aldrin's first words on the moon?", quiz4.getId(), "Beautiful view", "The moon is a cheese after all", "Hello world!", "That's one small step for a man, one giant leap for mankind", 1, quiz4);
=======

        q1_1 = new Question("How many legs does a dog have?", "2", "4", "6", "8", 2, quiz1);
        q1_2 = new Question("How many legs does a duck have?", "2", "4", "6", "8", 1, quiz1);
        q2_1 = new Question("What country is Florida in?", "France", "Sweden", "USA", "UK", 3, quiz2);
        q2_2 = new Question("What country is Perth in?", "New Zeland", "Indonesia", "India", "Australia", 4, quiz2);
        q3_1 = new Question("What is 2*3?", "9", "6", "5", "8", 2, quiz3);
        q3_2 = new Question("What is 2^3?", "9", "6", "5", "8", 4, quiz3); 
        q4_1 = new Question("Which planet is closest to the sun?", "Pluto", "Venus", "Merkurius", "Mars", 3, quiz4);
        q4_2 = new Question("Which was the first country to send a human into space?", "Sweden", "USSR", "USA", "East Germany", 2, quiz4);
        q4_3 = new Question("What were Buzz Aldrin's first words on the moon?", "Beautiful view", "The moon is a cheese after all", "Hello world!", "That's one small step for a man, one giant leap for mankind", 1, quiz4);
>>>>>>> main

        questionDAO.create(q1_1);
        questionDAO.create(q1_2);
        questionDAO.create(q2_1);
        questionDAO.create(q2_2);
        questionDAO.create(q3_1);
        questionDAO.create(q3_2);
        questionDAO.create(q4_1);
        questionDAO.create(q4_2);
        questionDAO.create(q4_3);

        rat1 = new Ratings(1, 5, "Wow this is the best ever! I am so mother puffing impressed", acc3, quiz1);
        rat2 = new Ratings(1, 1, "Wtf who doesn't know how many legs these animals have?", acc2, quiz1);
        rat3 = new Ratings(2, 4, "Wow this was the most difficult ever!", acc1, quiz2);
        rat4 = new Ratings(2, 2, "Lol noo everyone knows Florida is in AMERICA pfft not USA. Idiot!", acc3, quiz2);
        rat5 = new Ratings(3, 5, "Great! I am 10 and learned alot. I got all right!", acc1, quiz3);
        rat6 = new Ratings(3, 5, "Pfft no this is wrong! 2^3 is 9!", acc2, quiz3);

        ratingsDAO.create(rat1);
        ratingsDAO.create(rat2);
        ratingsDAO.create(rat3);
        ratingsDAO.create(rat4);
        ratingsDAO.create(rat5);
        ratingsDAO.create(rat6);
<<<<<<< HEAD

    }*/
=======
    }
>>>>>>> main

}
