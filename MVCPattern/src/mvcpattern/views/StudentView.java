/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpattern.views;

import mvcpattern.controllers.StudentController;
import mvcpattern.model.StudentModel;
import mvcpattern.model.Student;

/**
 *
 * @author alumne
 */
public class StudentView {

    private StudentController controller;
    private StudentModel model;

    public StudentView(StudentController controller, StudentModel model) {
        this.controller = controller;
        this.model = model;
    }

    public void printStudentDetails(Student student) {
        System.out.println("Student: ");
        //Student student = model.getStudent();
        System.out.println("Name: " + student.getName());
        System.out.println("Roll No: " + student.getRollNo());
    }
}
