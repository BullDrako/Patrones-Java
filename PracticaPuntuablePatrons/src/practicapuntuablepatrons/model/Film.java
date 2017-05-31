/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.model;

import java.util.Objects;

/**
 *
 * @author alumne
 *
 * implements interface film
 */
public class Film {

    private String title;
    private String director;
    private String description;
    private int year;

    public Film() {
    }

    public Film(String title, String director, String description, int year) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.year = year;
    }

    public Film(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
            if(object instanceof Film) { //is it a Film?
                //Check the values of the parameters
                Film other = (Film) object;
                b = (this.title.equals(other.title));
            } else b = false;
        }
        return b;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{Film: ");
        sb.append("title = ");
        sb.append(title);
        sb.append("; director = ");
        sb.append(director);
        sb.append("; description = ");
        sb.append(description);
        sb.append("; year = ");
        sb.append(year);
        sb.append("}");
        return sb.toString();
    }

}
