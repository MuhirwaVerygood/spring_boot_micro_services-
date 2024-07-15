package com.verygoodd.school.client;


import com.netflix.discovery.provider.Serializer;
import com.verygoodd.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url ="${application.config.student-url}")
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentsBySchoolId(@PathVariable("school-id") Integer schoolId);
}
