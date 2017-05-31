/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica;

import mvcpractica.model.FriendModel;
import mvcpractica.Controllers.FriendController;

/**
 * <strong>FriendsApp.java</strong>
 * Application to manage friends.
 *
 * @author Proven
 */
public class FriendsApp {

    public static void main(String[] args) {
        FriendModel model = new FriendModel();
        FriendController control = new FriendController(model);
        control.doAction();
    }
}
