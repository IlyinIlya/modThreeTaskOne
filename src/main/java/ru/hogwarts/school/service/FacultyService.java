package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> get(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getByNameOrColor(String name, String color) {
        if (name != null && color != null) {
            return facultyRepository.findByNameAndColor(name, color);
        }
        if (name != null) {
            return facultyRepository.findByName(name);
        }
        if (color != null) {
            return facultyRepository.findByColor(color);
        }
        return facultyRepository.findAll();
    }
}