package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long counter = 0;

    public Student create(Student student) {
        long id = ++counter;
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public Student get(Long id) {
        return students.get(id);
    }

    public Student update(Long id, Student student) {
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public void delete(Long id) {
        students.remove(id);
    }

    public List<Student> getByAge(int age) {
        return students.values().stream()
                .filter(student -> student.getAge() == age).toList();
    }
}
