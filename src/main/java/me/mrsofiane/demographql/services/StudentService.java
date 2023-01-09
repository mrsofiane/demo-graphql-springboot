package me.mrsofiane.demographql.services;

import me.mrsofiane.demographql.entities.Student;
import me.mrsofiane.demographql.exceptions.StudentNotFoundException;
import me.mrsofiane.demographql.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> {
                throw new StudentNotFoundException("Student with id "+studentId+" not found");
        });
    }

    public Student addStudent(Student student) {
       return studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student updateStudentById(Student student, Long studentId) {
        Student currentStudent = studentRepository.findById(studentId).orElseThrow(() -> {
            throw new StudentNotFoundException("Student with id "+studentId+" not found");
        });
        currentStudent.setName(student.getName());
        currentStudent.setEmail(student.getEmail());
        return studentRepository.save(currentStudent);
    }
}
