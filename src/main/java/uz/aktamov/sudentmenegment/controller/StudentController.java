package uz.aktamov.sudentmenegment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.aktamov.sudentmenegment.entity.Group;
import uz.aktamov.sudentmenegment.entity.Student;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/student/")
public class StudentController implements BaseController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Student> users() {
        return STUDENTS;
    }

    public Student getById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return STUDENTS.stream().filter(group -> group.getId().equals(uuid)).findFirst()
                    .orElseThrow(() -> {
                                throw new RuntimeException("Group not found");
                            }
                    );
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
