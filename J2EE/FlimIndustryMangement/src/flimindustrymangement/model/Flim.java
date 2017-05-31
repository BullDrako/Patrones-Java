/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.model;

import java.util.Objects;

/**
 *
 * @author jashan
 */
public class Flim {
    
    private String title;
    private String director;
    private String description;
    private int year;

    public Flim() {
    }

    public Flim(String title) {
        this.title = title;
    }

    public Flim(String title, String director, String description, int year) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.year = year;
    }
    
    public Flim(Flim other) {
        this.title = other.title;
        this.director = other.director;
        this.description = other.description;
        this.year = other.year;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Flim{" + "title=" + title + ", director=" + director + ", description=" + description + ", year=" + year + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean b;
        if(this == object) b = true; //Same object
        else {
            if(object instanceof Flim) { //Its a Friend?
                //Check the values of the parameters
                Flim other = (Flim) object;
                b = (this.title.equals(other.title));
            } else b = false;
        }
        return b;
    }
    
    
    
    
    
    
}
