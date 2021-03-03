/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Ratings;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Antpack
 */
@Named
@ViewScoped
public class RatingsListBean implements Serializable {

    private List<Ratings> allRatings;
    private Ratings selectedRating;
    private List<Ratings> selectedRatings;

    @Inject
    private RatingsDAO ratingsDAO;

    //  private RatingsController ratingsController;
    @PostConstruct
    public void postConstruct() {
        allRatings = ratingsDAO.findAll();

    }

    public List<Ratings> getRatings() {
        return allRatings;
    }

    public Ratings getSelectedRatings() {
        return selectedRating;
    }

    public void setSelectedProduct(Ratings selectedRating) {
        this.selectedRating = selectedRating;
    }

    public List<Ratings> getSelectedProducts() {
        return selectedRatings;
    }

    public void setSelectedProducts(List<Ratings> selectedRatings) {
        this.selectedRatings = selectedRatings;
    }

    public void openNew() {
        this.selectedRating = new Ratings();
    }

    public void deleteRating() {
        this.allRatings.remove(this.selectedRating);
        this.selectedRating = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-ratings");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedRatings()) {
            int size = this.selectedRatings.size();
            return size > 1 ? size + " ratings selected" : "1 ratings selected";
        }

        return "Delete";
    }

    public boolean hasSelectedRatings() {
        return this.selectedRatings != null && !this.selectedRatings.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.allRatings.removeAll(this.selectedRatings);
        this.selectedRatings = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ratings Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-ratings");
        PrimeFaces.current().executeScript("PF('dtratings').clearFilters()");
    }

}
