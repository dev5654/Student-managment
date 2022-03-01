package uz.aktamov.sudentmenegment.controller;

import org.springframework.web.bind.annotation.*;
import uz.aktamov.sudentmenegment.entity.Subject;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/subject/")
public class SubjectController implements BaseController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Subject> subjects() {
        return SUBJECTS;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Subject create(@RequestBody Subject subject) {
        SUBJECTS.add(subject);
        return subject;
    }

    @RequestMapping(value = "/{id}")
    public Subject subjects(@PathVariable String id) {
        return getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable String id) {
        Subject subject = getById(id);
        GROUPS.remove(subject);
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Subject update(@PathVariable String id, @RequestBody Subject subject) {
        Subject subject1 = getById(id);
        subject1.setName(subject.getName());
        subject1.setDescription(subject.getDescription());
        return subject1;
    }


    public Subject getById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return SUBJECTS.stream().filter(subject -> subject.getId().equals(uuid)).findFirst()
                    .orElseThrow(() -> {
                                throw new RuntimeException("Subject not found");
                            }
                    );
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}