/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpractica.views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;

/**
 * <strong>Menu.java</strong>
 * Class Menu. Encapsulates the creation and use of a generic menu.
 *
 * @author Jose Moreno
 */
public class Menu {

    /*======Attributes======*/
    /**
     * <strong>options</strong>
     * the options of the menu.
     */
    private final List<Option> options;
    private final String title;

    /* Constructor */
    /**
     * <strong>Menu()</strong>
     * Menu constructor
     *
     * @param title title of menu.
     */
    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
    }

    /*======Accessors======*/
    /**
     * <strong>getTitle()</strong>
     * gets the menu title
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * <strong>get()</strong>
     * gets the option with the specified index
     *
     * @param index number of option to return.
     * @return the option is the specified position of the list
     */
    public Option get(int index) {
        return options.get(index);
    }

    /*======Methods=======*/
    /**
     * <strong>add()</strong>
     * adds an option to the list
     *
     * @param option option object to be added.
     */
    public void add(Option option) {
        options.add(option);
    }

    /**
     * <strong>remove()</strong>
     * removes an option from the list
     *
     * @param option object to be removed.
     * @return true if option has been found, false otherwise
     */
    public boolean remove(Option option) {
        return options.remove(option);
    }

    /**
     * <strong>remove()</strong>
     * removes an option (given its position) from the list
     *
     * @param index option position to be removed.
     * @return the option deleted
     */
    public Option remove(int index) {
        return options.remove(index);
    }

    /**
     * <strong>hashCode()</strong>
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.title);
        return hash;
    }

    /**
     * <strong>equals()</strong>
     *
     * @param obj obj to compare to.
     * @return true if this object is equal to obj, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    /**
     * <strong>toString()</strong>
     * converts this object to string
     *
     * @return String conversion
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("============%s============", getTitle()));
        ListIterator<Option> it = options.listIterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    /**
     * <strong>display()</strong>
     * displays the menu.
     */
    public void display() {
        System.out.format("\n============%s============\n", title);
        ListIterator<Option> it = options.listIterator();
        int idOption = 0;
        while (it.hasNext()) {
            showMessage(String.format("[%d] %s\n", idOption, it.next().toString()));
            idOption++;
        }
    }

    /**
     * <strong>getUserOption()</strong>
     * gets input from user to select an option if error, it returns the default
     * value -1
     *
     * @return a value identifying the selected option
     */
    public int getUserOption() {
        Scanner sc = new Scanner(System.in);
        int opt;
        try {
            System.out.print("Choose an option: ");
            opt = sc.nextInt();
            if ((opt < 0) || (opt >= options.size())) {
                opt = -1;
            }
        } catch (InputMismatchException ime) {
            opt = -1;
        }
        return opt;
    }

    /**
     * <strong>showMessage()</strong>
     *
     * @param message to display.
     */
    public void showMessage(String message) {
        System.out.print(message);
    }

    /**
     * <strong>inputString()</strong>
     *
     * @param message to display.
     * @return String inputted.
     */
    public String inputString(String message) {
        System.out.print(message);
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return input;
    }

    public int inputInt(String message) {
        System.out.print(message);
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }
}
