/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmsAndActors.model.persist;

import filmsAndActors.model.Film;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Edgar
 */
public class FilmArrayDao implements FilmDaoInterface{
    List<Film> films;
    
     public FilmArrayDao() {
        films = new ArrayList<>();
    }
    
    @Override
    public List<Film> findAll() {
        return films;
    }
    
    
    @Override
    public Film find(Film f) {
         Film film = null;
        for(Film a : films) {
            if(a.equals(f)){
                film = a;
                break;
            }
        }
        return film;
    }

    @Override
    public boolean add(Film film) {
        boolean result = false;
        if(film != null) {
            if(find(film) == null) {
                films.add(film);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean update(Film film) {
         boolean result = false;
        if(film != null){
            Film fil = null;
            fil = find(film);
            if(fil!=null) {
                fil.setDirector(film.getDirector());
                fil.setDescription(film.getDescription());
                fil.setYear(film.getYear());
                result = true;
            }
        }
        return result;  
    }

    @Override
    public boolean delete(Film film) {
         boolean result = false;
        if(films.remove(film)) {
            result = true;
        }
        return result;
    }

}
