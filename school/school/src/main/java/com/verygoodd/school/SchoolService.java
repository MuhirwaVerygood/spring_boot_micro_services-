package com.verygoodd.school;

import com.verygoodd.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient studentClient;

    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findAllStudentsBySchoolId(Integer schoolId) {
        School school = repository.findById(schoolId).orElse(School.builder()
                .name("NOT_FOUND").email("NOT_FOUND").build());

        var students = studentClient.findAllStudentsBySchoolId(schoolId);
        return FullSchoolResponse
                .builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
