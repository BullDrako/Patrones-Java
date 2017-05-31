/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frienddao.model.persistance;
import frienddao.model.Friend;

import java.util.List;


/**
 *
 * @author Edgar
 * 
 * primero documentar interface
 */
public interface FriendDao {
    /**
     * adds a new friend to persistende media
     * preventing phone duplicates
     * @param friend to add
     * @return true if succesfull, false otherwise
     */
    public boolean add(Friend friend);
    
    /**
     * update a friend to persistende media
     * @param friend to modify
     * @return true if succesfull, false otherwise
     */
    public boolean update(Friend friend);
    
    /**
     * deletes a friend to persistende media
     * @param friend to delete
     * @return true if succesfull, false otherwise
     */
    public boolean delete(Friend friend);
    
    /**
     * recieve all friends from persistence media
     * @return all friend object or if is empty shows a message... que devuelve cuando falla  
     */
    public List<Friend> findAll();
    
    /**
     * searches a friend
     * @param friend to search
     * @return friend with given data or null...
     */
    public Friend find(Friend friend);
    
    /**
     * searches a friend with the given phone
     * @param phone to search
     * @return friend with given data or null
     */
    public Friend findByPhone(String phone);
    
    /***
     * searches all friends with the given name
     * @param name to search
     * @return a list of friends or if is null shows a message...
     */
    public List<Friend> FindByName(String name);
    
}
