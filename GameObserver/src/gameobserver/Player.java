/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobserver;


import java.util.Observable;

/**
 *
 * @author Edgar
 */
public class Player extends Observable {

    String userName;
    int points;

    public Player(String userName, int points) {
        this.userName = userName;
        this.points = points;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setAttack(Player p) {
        
        setChanged();
        this.notifyObservers(p);
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("{Player: ");
        sb.append("UserName = "); sb.append(userName);
        sb.append("; Points = "); sb.append(points);
        sb.append("}");

        return sb.toString();
    }

}
