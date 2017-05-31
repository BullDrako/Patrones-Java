/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.model.persist;

import mvcpractica.model.Friend;
import java.util.ArrayList;
import java.util.List;
import mvcpractica.model.persist.FriendDao;

/**
 *
 * @author Edgar
 */
public class FriendArrayDao implements FriendDao {

    List<Friend> datasource;

    public FriendArrayDao() {
        datasource = new ArrayList<>();
    }

    @Override
    public boolean add(Friend friend) {
        boolean result = false;
        if (friend != null) {
            if (find(friend) == null) {
                datasource.add(friend);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean update(Friend friend) {
        boolean result = false;
        if (friend != null) {
            Friend fr = null;
            fr = findByPhone(friend.getPhone());
            if (fr != null) {
                fr.setName(friend.getName());
                fr.setAge(friend.getAge());
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(Friend friend) {
        boolean result = false;
        if (datasource.remove(friend)) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Friend> findAll() {
        if(datasource.isEmpty()){
            System.out.println("The list is empty");
        }
        return datasource;
    }

    @Override
    public Friend find(Friend friend) {
        Friend fr = null;
        for (Friend f : datasource) {
            if (f.equals(friend)) {
                fr = f;
                break;
            }
        }
        return fr;
    }

    @Override
    public Friend findByPhone(String phone) {
        Friend fr = null;
        for (Friend f : datasource) {
            if (f.getPhone().equals(phone)) {
                fr = f;
                break;
            }
        }
        return fr;
    }

    @Override
    public List<Friend> FindByName(String name) { 
        List<Friend> datasource = new ArrayList<>();
        for (Friend f : this.datasource) {
            if (f.getName().equals(name)) {
                datasource.add(f);
            }
        }
        if(datasource.isEmpty()){
            System.out.println("The friend not exists");
        }
        return datasource;
    }

}
