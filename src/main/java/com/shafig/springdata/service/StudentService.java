package com.shafig.springdata.service;

import com.shafig.springdata.model.dto.request.StudentRequestDto;
import com.shafig.springdata.model.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    void saveAll(List<StudentRequestDto> students);
    Page<Student> getAllStudents(int page, int size);
    StudentRequestDto getById(Long id);
    void save(StudentRequestDto student);
    void deleteById(Long id);
    void testPlusOneProblem();
}
