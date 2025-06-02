package simplerestappfortest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import simplerestappfortest.models.Student;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(currentId++);
            students.add(student);
        } else {
            deleteById(student.getId());
            students.add(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
} 