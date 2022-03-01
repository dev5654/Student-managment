package uz.aktamov.sudentmenegment.controller;

import org.springframework.web.bind.annotation.*;
import uz.aktamov.sudentmenegment.entity.Group;
import uz.aktamov.sudentmenegment.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/group/")
public class GroupController implements BaseController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Group> groups() {
        return GROUPS;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Group create(@RequestBody Group group) {
        GROUPS.add(group);
        return group;
    }

    @RequestMapping(value = "/{id}")
    public Group get(@PathVariable String id) {
        return getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable String id) {
        Group group = getById(id);
        GROUPS.remove(group);
        return null;
    }

    @RequestMapping(value = "/{id}/{groupId}", method = RequestMethod.POST)
    public void addMember(@PathVariable String id, @PathVariable String groupId) {
        Student student = new StudentController().getById(id);
        Group group = getById(groupId);
        List<Student> students = Objects.isNull(group.getStudents()) ? new ArrayList<>() : group.getStudents();
        students.stream().filter(student1 -> !student1.getId().toString().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("User already has been added");
                });
        students.add(student);
        group.setStudents(students);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Group update(@PathVariable String id, @RequestBody Group group) {
        Group group1 = getById(id);
        group1.setName(group.getName());
        group1.setStudents(group.getStudents());
        return group1;
    }


    private Group getById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return GROUPS.stream().filter(group -> group.getId().equals(uuid)).findFirst()
                    .orElseThrow(() -> {
                                throw new RuntimeException("Group not found");
                            }
                    );
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
