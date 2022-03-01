package uz.aktamov.sudentmenegment.controller;

import uz.aktamov.sudentmenegment.entity.Group;
import uz.aktamov.sudentmenegment.entity.Student;
import uz.aktamov.sudentmenegment.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public interface BaseController {

    List<Group> GROUPS = new ArrayList<>(List.of(
            new Group("Mushketyorlar")
    ));
    List<Student> STUDENTS = new ArrayList<>(List.of(
            new Student("Asliddin", "7778", "asliddin", "123", null)
    ));
    List<Subject> SUBJECTS = new ArrayList<>();


}
