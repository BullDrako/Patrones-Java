/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern.model.persistance;

import daopattern.model.Student;
import java.util.List;

/**
 *
 * @author Edgar
 */
public interface StudentDaoInterface {

    public List<Student> getAllStudents();

    public Student getStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);

    public void addStudent(Student student);

}
