/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimindustrymangement.model.persist;

import flimindustrymangement.model.Actor;
import flimindustrymangement.model.Flim;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne
 */
public class FlimArrayDao implements FlimDaoInterface {
    
    List<Flim> flims;
    
     public FlimArrayDao() {
        flims = new ArrayList<>();
    }
    
    @Override
    public List<Flim> findAll() {
        return flims;
    }



    @Override
    public Flim find(Flim f) {
         Flim flim = null;
        for(Flim a : flims) {
            if(a.equals(f)){
                flim = a;
                break;
            }
        }
        return flim;
    }

    @Override
    public boolean add(Flim flim) {
        boolean result = false;
        if(flim != null) {
            if(find(flim) == null) {
                flims.add(flim);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean update(Flim flim) {
        boolean result = false;
        if(flim != null){
            Flim fli = null;
            fli = find(flim);
            if(fli!=null) {
                fli.setDirector(flim.getDirector());
                fli.setDescription(flim.getDescription());
                fli.setYear(flim.getYear());
                result = true;
            }
        }
        return result;  
    }

    @Override
    public boolean delete(Flim flim) {
        boolean result = false;
        if(flims.remove(flim)) {
            result = true;
        }
        return result;
    }
    
}
