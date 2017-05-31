/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.views;

/**
 * <strong>Option.java</strong>
 * Class Option. Encapsulates one option for a generic menu.
 *
 * @author Jose Moreno
 */
public class Option {

    /*=======Attributes=======*/
    private final String description;

    /*=======Constructors=======*/
    /**
     * <strong>Option()</strong>
     * Option constructor
     *
     * @param desc description of option.
     */
    public Option(String desc) {
        description = desc;
    }

    /*=======Methods=======*/
    /**
     * <strong>toString()</strong>
     * converts option to string
     *
     * @return String conversion
     */
    @Override
    public String toString() {
        return description;
    }
}
