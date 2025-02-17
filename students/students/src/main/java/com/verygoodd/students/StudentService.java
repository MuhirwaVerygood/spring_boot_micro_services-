package com.verygoodd.students;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchoolId(Integer schoolId) {
        var students = repository.findStudentBySchoolId(schoolId);
        return students;
    }
}
