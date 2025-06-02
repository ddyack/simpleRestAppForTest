package simplerestappfortest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import simplerestappfortest.exception.BadRequestException;
import simplerestappfortest.exception.StudentNotFoundException;
import simplerestappfortest.models.Student;
import simplerestappfortest.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student createStudent(Student student) {
        if (student.getId() != null) {
            throw new BadRequestException("A new student cannot already have an ID");
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        if (!studentRepository.findById(id).isPresent()) {
            throw new StudentNotFoundException(id);
        }
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.findById(id).isPresent()) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }
} 