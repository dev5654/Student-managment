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
public class Student {
    private UUID id = UUID.randomUUID();
    private String fullName;
    private String phone;
    private String username;
    private String password;
    private List<Subject> subjects;

    public Student(String fullName, String phone, String username, String password, List<Subject> subjects) {
        this.fullName = fullName;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.subjects = subjects;
    }
}
