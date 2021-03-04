/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
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

/**
 * Backing Bean for playquiz.xhtml.
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

    private List<Question> questions;
    private Question currentQuestion;
    private int currentQuestionIndex;
    private int correctAnswerIndex;

    private boolean isAnswered;
    private int points;

    /*public List<Question> getQuestions() {

        questions = questionDAO.findQuestionsinQuiz(quizDAO.find(quizId));
        currentquestion = questions.get(0);

        return questions;
    }*/
    public Question getcurrentQuestion() {

        if (questions == null) {
            questions = questionDAO.findQuestionsinQuiz(quizDAO.find(quizId));
        }

        currentQuestion = questions.get(currentQuestionIndex);
        correctAnswerIndex = currentQuestion.getAnswer();

        return currentQuestion;
    }

    public void nextQuestion() {
        currentQuestionIndex++;
        isAnswered = false;

    }

    public void incPoints() {
        points++;
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public boolean isCorrectAnswer(int answer) {
        return (answer == correctAnswerIndex);
    }

    public void correctAnswer() {
        if (isAnswered) {
            return;
        }

        addMessage(FacesMessage.SEVERITY_INFO, "Correct answer", "1 point");
        points++;
        isAnswered = true;
    }

    public void incorrectAnswer() {
        if (isAnswered) {
            return;
        }

        addMessage(FacesMessage.SEVERITY_ERROR, "Incorrect answer", "No point for you");
        isAnswered = true;
    }

}
