/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern.model;

/**
 *
 * @author Edgar
 */
public class Student {

    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

}

//buscar por telefono
//afegir devuleve true false o si se ha añadido o no
//borrar
//actualiztar
//buscar

/*
freindDaoInterface
+add friend(friend f)?

+update(friend f)?

+delete(friend f)?

+findAll(): List<friend>
+findByPhone(String phone): friend
+find(friend f): friend
+findByName(String name): List<friend>

*/
