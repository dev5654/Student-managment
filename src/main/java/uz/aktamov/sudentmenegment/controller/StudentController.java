package uz.aktamov.sudentmenegment.controller;

import org.springframework.web.bind.annotation.*;
import uz.aktamov.sudentmenegment.entity.Student;
import uz.aktamov.sudentmenegment.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/student/")
public class StudentController implements BaseController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Student> students() {
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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Student create(@RequestBody Student student) {
        STUDENTS.add(student);
        return student;
    }


    @RequestMapping(value = "/{id}")
    public Student get(@PathVariable String id) {
        return getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        STUDENTS.remove(getById(id));
    }

    public Student update(@PathVariable String id, @PathVariable Student student) {
        Student student1 = getById(id);
        student1.setFullName(student.getFullName());
        student1.setPassword(student.getPassword());
        student1.setUsername(student.getUsername());
        student1.setPhone(student.getPhone());
        student1.setSubjects(student.getSubjects());
        return student1;
    }

    @RequestMapping(value = "/{id}/{subjectId}", method = RequestMethod.POST)
    public void addSubject(@PathVariable String id, @PathVariable String subjectId) {
        Student student = getById(id);
        Subject subject = new SubjectController().getById(subjectId);
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        student.setSubjects(subjects);
    }


}
