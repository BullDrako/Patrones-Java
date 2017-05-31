/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frienddao;

/*
import friendmanager.model.Friend;
import friendmanager.model.persistence.FriendDAO;
import friendmanager.model.persistence.FriendDAOImpl;
 */
import frienddao.model.Friend;
import frienddao.model.persistance.FriendDao;
import frienddao.model.persistance.FriendArrayDao;

import java.util.List;

/**
 *
 * @author Edgar
 */
public class FriendDaoApp {

    public static void main(String[] args) {
        FriendDaoApp myapp = new FriendDaoApp();

        myapp.run();
    }

    private void run() {

        FriendDao friendDao = new FriendArrayDao();
        boolean b = false;

        //populate the data source
        b = friendDao.add(new Friend("Peter1", "111", 21));
        System.out.println(b ? "1 friend added" : "Error adding");//condicional ternario
        b = friendDao.add(new Friend("Peter2", "112", 22));
        System.out.println(b ? "1 friend added" : "Error adding");
        b = friendDao.add(new Friend("Peter3", "113", 23));
        System.out.println(b ? "1 friend added" : "Error adding");
        b = friendDao.add(new Friend("Peter4", "114", 24));
        System.out.println(b ? "1 friend added" : "Error adding");
        b = friendDao.add(new Friend("Peter5", "115", 25));
        System.out.println(b ? "1 friend added" : "Error adding");
        b = friendDao.add(new Friend("Peter6", "116", 26));
        System.out.println(b ? "1 friend added" : "Error adding");
        //show data
        /*List<Friend> data = friendDao.findAll();
        System.out.println(data.toString());*/
        displayData(friendDao.findAll());

        //modify friends
        /*b = friendDao.update(new Friend("112", "John2", 32));
        System.out.println(b ? "1 friend successfully modified" : "Error modifying");
        displayData(friendDao.findAll());*/
        System.out.println("");
        System.out.println("-Update ok-");
        b = friendDao.update(new Friend("Peter7", "116", 66));
        System.out.println(b ? "1 friend succesfully modified" : "Error modifying");
        displayData(friendDao.findAll());
        
        System.out.println("");
        System.out.println("-Update fail-");
        b = friendDao.update(new Friend("Peter7", "110", 88));
        System.out.println(b ? "1 friend succesfully modified" : "Error modifying");
        displayData(friendDao.findAll());
        
        System.out.println("");
        System.out.println("-Remove OK-");
        b = friendDao.delete(new Friend("Peter7", "116", 66));
        System.out.println(b ? "1 friend succesfully deleted" : "Error removing");
        displayData(friendDao.findAll());
        
        System.out.println("");
        System.out.println("-Remove fail-");
        b = friendDao.delete(new Friend("hola", "777", 66));
        System.out.println(b ? "1 friend succesfully deleted" : "Error removing");
        displayData(friendDao.findAll());

        System.out.println("----");
        System.out.println("FIND BY PHONE");
        System.out.println(friendDao.findByPhone("114"));
        
        System.out.println("FIND BY PHONE null");
        System.out.println(friendDao.findByPhone("777"));
        
        System.out.println("----");
        System.out.println("FIND ok");
        //b = friendDao.find(friend);
        System.out.println(friendDao.find(new Friend("Peter1", "111", 21)));
        
        System.out.println("FIND null");
        System.out.println(friendDao.find(new Friend("Peter1", "000", 21)));
        
        System.out.println("----");
        System.out.println("FIND BY NAME");
        System.out.println(friendDao.FindByName("Peter1"));
        
        System.out.println("FIND BY NAME null");
        System.out.println(friendDao.FindByName("nombre"));
    }

    private void displayData(List<Friend> data) {
        for (Friend f : data) {
            System.out.println(f.toString());
        }
    }
}
