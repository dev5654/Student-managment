package uz.aktamov.sudentmenegment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Subject {
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
}
