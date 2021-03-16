/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.view;

import com.quizapp.dat076.model.UserBean;
import com.quizapp.dat076.model.dao.LeaderboardDAO;
import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Leaderboard;
import com.quizapp.dat076.model.entity.Question;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.Param;
import org.primefaces.PrimeFaces;

/**
 * Backing Bean for playquiz.xhtml.
 *
 * @author Anton Blomdell
 * @author Albin
 */
@Data
@Named
@ViewScoped
public class PlayQuizBackingBean implements Serializable {

    @Inject
    @Param(name = "quizId")
    private int quizId;

    @EJB
    private QuizDAO quizDAO;

    @EJB
    private QuestionDAO questionDAO;

    @EJB
    private LeaderboardDAO leaderboardDAO;
    @Inject
    UserBean user;

    private List<Question> questions;
    private Question currentQuestion;
    private int currentQuestionIndex;
    private int correctAnswerIndex;

    private boolean isCurrentQuestionAnswered;
    private int points;
    private int maximumpoints;

    private int timer = 10;
    private boolean isTimerAtZero = false;

    private boolean isFinished;

    /*public List<Question> getQuestions() {

        questions = questionDAO.findQuestionsinQuiz(quizDAO.find(quizId));
        currentquestion = questions.get(0);

        return questions;
    }*/
    public Question getcurrentQuestion() {

        if (questions == null) {
            questions = questionDAO.findQuestionsinQuiz(quizDAO.find(quizId));
            maximumpoints = questions.size() * 10;
        }

        currentQuestion = questions.get(currentQuestionIndex);
        correctAnswerIndex = currentQuestion.getAnswer();

        return currentQuestion;
    }

    public void nextQuestion() {
        isCurrentQuestionAnswered = false;
        currentQuestionIndex++;
        resetTimer();

    }

    private void resetTimer() {
        timer = 10;
        isTimerAtZero = false;
        
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public boolean isCorrectAnswer(int answer) {
        return (answer == correctAnswerIndex);
    }

    public void correctAnswer() {
        if (isCurrentQuestionAnswered) {
            return;
        }

        addMessage(FacesMessage.SEVERITY_INFO, "Correct answer", timer + " points");
        points += timer;
        isCurrentQuestionAnswered = true;
        isEndQuiz();
    }

    public void incorrectAnswer() {
        if (isCurrentQuestionAnswered) {
            return;
        }

        addMessage(FacesMessage.SEVERITY_ERROR, "Incorrect answer", "No point for you");
        isCurrentQuestionAnswered = true;
         isEndQuiz();
    }

    private void timeOut() {
        addMessage(FacesMessage.SEVERITY_WARN, "Time out!!!", "You missed your chance to answer");
        isCurrentQuestionAnswered = true;
        isTimerAtZero = true;
        PrimeFaces.current().ajax().update("questionform");
    }

    public void decrementTimer() {

        //As long as the timer is above zero and the current question is 
        //unanswered, count down the timer
        if (!isTimerAtZero && !isCurrentQuestionAnswered) {

            timer--;

            //When the timer reaches zero, call timeOut()
            if (timer == 0) {

                timeOut();

            }

        }

    }

    public void isEndQuiz() {

       if((isCurrentQuestionAnswered== true) && (currentQuestionIndex +1 == questions.size()) ){
        isFinished = true;
       }
       else{
       isFinished = false;
       }
        
       

    }

    public String add() {
        System.out.println("TAILS");
        if (user.isUser() == true) {
            Leaderboard result = new Leaderboard(user.getAccount(), quizDAO.findQuizByID(quizId), points);
            leaderboardDAO.create(result);
            System.out.println("SONIC");
            
        }
        return "success";
    }

}
