package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long counter= 0;

    public Faculty create(Faculty faculty) {
        long id = ++counter;
        faculty.setId(id);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty get(Long id) {
        return faculties.get(id);
    }

    public Faculty update(Long id, Faculty faculty) {
        faculty.setId(id);
        faculties.put(id, faculty);
        return faculty;
    }

    public void delete(Long id) {
        faculties.remove(id);
    }

    public List<Faculty> getByNameOrColor(String name, String color) {
        return faculties.values().stream()
                .filter(faculty ->
                        name == null || faculty.getName().equalsIgnoreCase(name))
                .filter(faculty ->
                        color == null || faculty.getColor().equalsIgnoreCase(color))
                .toList();
    }
}
