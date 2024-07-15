package com.verygoodd.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolControllers {
    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        service.saveSchool(school);
    }



    @GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(service.findAllSchools());
    }


    @GetMapping("/school-with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId){
        return ResponseEntity.ok(service.findAllStudentsBySchoolId(schoolId));
    }
}
