/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapuntuablepatrons.model.persist;

import java.util.ArrayList;
import java.util.List;
import practicapuntuablepatrons.model.Film;

/**
 *
 * @author alumne
 */
public class FilmArrayDao implements FilmDaoInterface {

    List<Film> films;

    public FilmArrayDao() {
        films = new ArrayList<>();
    }

    @Override
    public boolean addFilm(Film film) {
        boolean result = false;
        if (film != null) {
            if (find(film) == null) {
                films.add(film);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean updateFilm(Film film) {
        boolean result = false;
        if (film != null) {
            Film fi = null;
            if (fi != null) {
                fi.setDirector(film.getDirector());
                fi.setDescription(film.getDescription());
                fi.setYear(film.getYear());

                result = true;
            }
        }
        return result;

    }

    @Override
    public boolean deleteFilm(Film film) {
        boolean result = false;
        if (films.remove(film)) {
            result = true;
        }
        return result;
    }

    @Override
    public Film find(Film film) {
        Film fi = null;
        for (Film f : films) {
            if (f.equals(films)) {
                fi = f;
                break;
            }
        }
        return fi;
    }

    @Override
    public List<Film> findAllFilm() {
        if (films.isEmpty()) {
            System.out.println("The list is empty");
        }
        return films;
    }

    @Override
    public Film findByTitle(String title) {
        Film film = null;
        for (Film f : films) {
            if (f.getTitle().equals(title)) {
                film = f;
                break;
            }
        }
        return film;
    }

    @Override
    public Film findByDirector(String director) {
        Film film = null;
        for (Film f : films) {
            if (f.getDirector().equals(director)) {
                film = f;
                break;
            }
        }
        return film;
    }

}
