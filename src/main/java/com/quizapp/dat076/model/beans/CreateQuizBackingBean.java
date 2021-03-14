/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Emma Dirnberger
 * @author Anton Ekman
 */
@Data
@Named("createQuiz")
@ViewScoped
public class CreateQuizBackingBean implements Serializable {

    //Attributes
    @Size(min=3, max = 35, message="Too short or Too long")
    private String title;
    private Category category;
    @Size(min=3, max = 35, message="Too short or Too long")
    private String questionText;
    @Min(value = 1, message="Correct alternativ can only be 1,2,3 or 4")
    @Max(value = 4, message="Correct alternativ can only be 1,2,3 or 4")
    private int answerQuestion;
    @Size(min=1, max = 35, message="Too short or Too long")
    private String option1Question;
    @Size(min=1, max = 35, message="Too short or Too long")
    private String option2Question;
    @Size(min=1, max = 35, message="Too short or Too long")
    private String option3Question;
    @Size(min=1, max = 35, message="Too short or Too long")
    private String option4Question;


    @EJB
    private QuizDAO quizDAO;
    @EJB
    private CategoryDAO catDAO;
    @EJB
    private QuestionDAO questionDAO;

    @Inject
    private UserBean userBean;
    
    private List<Question> questionList;
    
    private Question tempQuestion;

    
    public CreateQuizBackingBean(){
    
            System.out.println("Constructor");
        questionList = new ArrayList<>();
        //tempQuestion = new Question(null,null,null,null,null,1,null);
    }
    
    
    /**
     * Adding a new quiz to the account
     *
     * @return
     */
    public String addQuiz() {
        Quiz quizToCreate = new Quiz(title, userBean.getAccount(), category);
        
        try{
        quizDAO.create(quizToCreate);
               System.out.println("WE got here5");
        for (Question q: questionList){
                   System.out.println("WE got here6");
            q.setQuiz(quizToCreate);
               System.out.println("WE got here7");
        questionDAO.create(q);
               System.out.println("WE got here8");
        }
         }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return "success";
    }

    /**
     * Turns the selected option (String) into a Category object
     *
     * @param event
     */
    public void onItemSelectedListener(SelectEvent event) {
        String catTitle = (String) event.getObject();
        Category selectedItem = catDAO.find(catTitle);
        category = selectedItem;
    }
    
    public void addQuestionToList(){
        
        try{
        tempQuestion = new Question(questionText,option1Question,option2Question,option3Question,option4Question,answerQuestion,null);
               System.out.println("WE got here1");
        questionList.add(tempQuestion);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
               System.out.println("WE got here2");
        clear();
    }
    
    public void clear(){
           System.out.println("WE got here3");
        tempQuestion.setQuestion(null);
        tempQuestion.setAlt1(null);
        tempQuestion.setAlt2(null);
        tempQuestion.setAlt3(null);
        tempQuestion.setAlt4(null);
        tempQuestion.setAnswer(1);
        
        System.out.println("WE got her4");
    
    }
}
