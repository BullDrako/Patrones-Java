/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobserver;

/**
 *
 * @author Edgar
 */
public class MainProgram {

    public static void main(String[] args) {
                
        Player pAlbert = new Player("Albert", 10);
        Player pJose = new Player("Jose", 10);
        Game g = new Game();
        pAlbert.addObserver(g);
        pJose.addObserver(g);

        pAlbert.setAttack(pJose);
        pJose.setAttack(pAlbert);
        pJose.setAttack(pAlbert);
        
    } 
}
