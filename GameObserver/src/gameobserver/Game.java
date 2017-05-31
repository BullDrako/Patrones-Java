/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobserver;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Edgar
 */
public class Game implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        processAttack((Player) o, (Player) arg);
    }

    private void processAttack(Player p, Player attacked) {

        int pointsAttacked;

        pointsAttacked = attacked.getPoints() - 1;

        attacked.setPoints(pointsAttacked);

        System.out.println("--" + p.getUserName() + " attacks " + attacked.getUserName() + "--");

        System.out.println(p.getUserName() + " has " + p.getPoints());
        System.out.println(attacked.getUserName() + " has " + attacked.getPoints());
        System.out.println();

    }
}
