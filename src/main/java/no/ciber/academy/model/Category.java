package no.ciber.academy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;
    private String CategoryDescription;

    public Category(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }

    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        CategoryDescription = categoryDescription;
    }

}
