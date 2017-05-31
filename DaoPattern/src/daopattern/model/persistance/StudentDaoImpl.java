/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern.model.persistance;

import daopattern.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class StudentDaoImpl implements StudentDaoInterface {
    //list is working as a database

    List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<>();
        Student student1 = new Student("Peter", 0);
        students.add(student1);
        Student student2 = new Student("Anne", 1);
        students.add(student2);
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        //System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
    }
    //retrieve list of students from the database

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        //System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

}
