/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpattern.controllers;

import mvcpattern.views.StudentView;
import mvcpattern.model.StudentModel;
import mvcpattern.model.Student;

/**
 *
 * @author alumne
 */
public class StudentController {

    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model) {
        this.model = model;
        this.view = new StudentView(this, model);
    }

    public void updateStudent(Student student) {
        model.setStudent(student);
        updateView();
    }

    public void findStudent() {
        Student student = model.getStudent();
        updateView();
    }

    public void updateView() {
        view.printStudentDetails(model.getStudent());
    }

}
