/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.model;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Edgar
 */
public class Friend {

    private String name;
    private String phone;
    private int age;

    public Friend() {
    }

    public Friend(String phone) {
        this.phone = phone;
    }

    public Friend( String phone, String name, int age) {
        this.phone = phone;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        boolean b;
        if (this == object) {//same object
            b = true;
        } else if (object instanceof Friend) {//is it a Friend
            //Check the values of the parameters
            Friend other = (Friend) object;
            b = (this.phone.equals(other.phone));
        } else {
            b = false;
        }
        return b;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("{Friend: ");
        sb.append("phone = "); sb.append(phone);
        sb.append("; name = "); sb.append(name);
        sb.append("; age = "); sb.append(age);
        sb.append("}");
        return sb.toString();
    }
}
