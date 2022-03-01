package uz.aktamov.sudentmenegment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private UUID id = UUID.randomUUID();
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.students=null;
    }
}
