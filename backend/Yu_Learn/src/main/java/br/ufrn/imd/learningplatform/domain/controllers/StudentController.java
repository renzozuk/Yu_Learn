package br.ufrn.imd.learningplatform.domain.controllers;

import br.ufrn.imd.learningplatform.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.learningplatform.domain.model.dto.StudentDTO;
import br.ufrn.imd.learningplatform.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/{organizationId}")
    public ResponseEntity<StudentDTO> createStudent(@PathVariable String organizationId, @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(studentService.createStudent(organizationId, registerRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable String id) {
        return new ResponseEntity<>(studentService.updateStudent(studentDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
