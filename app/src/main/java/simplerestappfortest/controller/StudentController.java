package simplerestappfortest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import simplerestappfortest.models.Student;
import simplerestappfortest.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(name = "Student", description = "Student management APIs")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Get all students", description = "Returns a list of all students")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of students")
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @Operation(summary = "Get a student by ID", description = "Returns a student by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved student"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @Parameter(description = "ID of student to be retrieved") @PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @Operation(summary = "Create a new student", description = "Creates a new student and returns the created student")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Student successfully created"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Student> createStudent(
            @Parameter(description = "Student to create") @RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity
            .created(URI.create("/api/students/" + savedStudent.getId()))
            .body(savedStudent);
    }

    @Operation(summary = "Update a student", description = "Updates a student by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Student successfully updated"),
        @ApiResponse(responseCode = "404", description = "Student not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @Parameter(description = "ID of student to be updated") @PathVariable Long id,
            @Parameter(description = "Updated student information") @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @Operation(summary = "Delete a student", description = "Deletes a student by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Student successfully deleted"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @Parameter(description = "ID of student to be deleted") @PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
} 