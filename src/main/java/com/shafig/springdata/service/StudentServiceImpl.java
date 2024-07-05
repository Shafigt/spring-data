package com.shafig.springdata.service;

import com.shafig.springdata.model.dto.request.StudentRequestDto;
import com.shafig.springdata.model.entity.Laptop;
import com.shafig.springdata.model.entity.Student;
import com.shafig.springdata.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void testPlusOneProblem() {
        var students = studentRepository.findAll();
        System.out.println(students.get(0).getId());

    }


    @Override
    public void deleteById(Long id) {
        var student = studentRepository.findById(id).get();
        student.getLaptops().remove(0);
        studentRepository.save(student);
    }

    @Override
    public void save(StudentRequestDto studentRequestDto) {
        var student = mapToStudent(studentRequestDto);
        var laptops = new ArrayList<Laptop>();
        laptops.add(new Laptop("samsung"));
        laptops.add(new Laptop("hp"));
        student.setLaptops(laptops);
        studentRepository.save(student);
    }

    @Override
    public StudentRequestDto getById(Long id) {

        var student = studentRepository.findById(id).orElse(null);

        if (!Objects.isNull(student)) {
            log.info(student.toString());
            var response = modelMapper.map(student, StudentRequestDto.class);
            log.info(response.toString());
            return response;
        }

        return null;
    }

    @Override
    public Page<Student> getAllStudents(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public void saveAll(List<StudentRequestDto> students) {

        List<Student> studentsToSave = students.stream()
                .map(this::mapToStudent)
                .collect(Collectors.toList());
        studentRepository.saveAll(studentsToSave);

    }

    private Student mapToStudent(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        return student;
    }
}
