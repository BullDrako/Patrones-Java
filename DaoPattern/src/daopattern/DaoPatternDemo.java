/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

import daopattern.model.Student;
import daopattern.model.persistance.StudentDaoImpl;
import daopattern.model.persistance.StudentDaoInterface;

/**
 *
 * @author Edgar
 */
public class DaoPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        StudentDaoInterface studentDao = new StudentDaoImpl();
        //print all students
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }
        //update student
        Student student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);
        //get the student
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");

        studentDao.addStudent(new Student("Joan", 3));
        studentDao.addStudent(new Student("Pere", 4));
        studentDao.addStudent(new Student("Pau", 5));

        System.out.println("...");
        for (Student st : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + st.getRollNo() + ", Name : " + st.getName() + " ]");
        }

        studentDao.deleteStudent(new Student("", 3)); //ha borrado pere

        System.out.println("..." + studentDao.getAllStudents());

        for (Student st1 : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + st1.getRollNo() + ", Name : " + st1.getName() + " ]");
        }
    }
}
