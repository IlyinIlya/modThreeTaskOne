package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgeBetweenValues(Integer minAge, Integer maxAge);

    List<Student> findByAgeGreaterValue(Integer minAge);

    List<Student> findByAgeLessValue(Integer maxAge);
}
