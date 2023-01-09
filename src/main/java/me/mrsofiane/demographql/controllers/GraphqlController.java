package me.mrsofiane.demographql.controllers;

import me.mrsofiane.demographql.entities.Student;
import me.mrsofiane.demographql.services.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphqlController {
    private final StudentService studentService;

    public GraphqlController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @QueryMapping
    public Student studentById(@Argument Long id) {
        return studentService.getStudentById(id);
    }

    @QueryMapping
    public Student addStudent(@Argument Student student) {
        return studentService.addStudent(student);
    }

    @QueryMapping
    public void deleteStudentById(@Argument Long id) {
        studentService.deleteStudentById(id);
    }

    @QueryMapping
    public Student updateStudentById(@Argument Long id, @Argument Student student) {
        return studentService.updateStudentById(student, id);
    }
}
