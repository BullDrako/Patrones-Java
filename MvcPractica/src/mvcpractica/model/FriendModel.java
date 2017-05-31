/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.model;

import java.util.List;
import mvcpractica.model.persist.FriendArrayDao;
import mvcpractica.model.persist.FriendDao;



/**
 *
 * @author Edgar
 * 
 * en daoInterface que al final no se hace habia:
 * extends film y actor
 * 
 * poner los 4 metodos crud pasandoles object no
 * 
 * crear un interface comun entre actor y film implements
 * 
 * filmArrayDao implements filmdaointerface y  ActorArraydao implements actordaointerface
 * 
 * 
 */
public class FriendModel {
    
    private FriendDao friendDao;
    
    public FriendModel(){
        friendDao = new FriendArrayDao();
    }

    public Friend find(Friend entity){
        return friendDao.find(entity);
    }
    
    public Friend findByPhone(String phone){
        return friendDao.findByPhone(phone);
    }
    
    public boolean insert(Friend entity){ 
        return friendDao.add(entity);
    }
    
    public boolean update(Friend entity){
        return friendDao.update(entity);
    }
    
    public boolean delete(Friend entity){
        return friendDao.delete(entity);
    }
    
    public List<Friend> findAll(){
        
        return friendDao.findAll();
    }
}
