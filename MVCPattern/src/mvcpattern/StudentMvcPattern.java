/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpattern;

import mvcpattern.controllers.StudentController;
import mvcpattern.model.StudentModel;
import mvcpattern.model.Student;

/**
 *
 * @author alumne
 */
public class StudentMvcPattern {

    public static void main(String[] args) {
        //create a new Student.
        Student st = retrieveStudentFromDatabase();
        //instantiate a data model.
        StudentModel model = new StudentModel();
        //insert into model.
        model.setStudent(st);
        //instantiate a controller.
        StudentController controller = new StudentController(model);
        //show view.
        controller.updateView();
        //update model data
        controller.updateStudent(new Student("01", "John"));
        //controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student("10", "Robert");
        return student;
    }
}
