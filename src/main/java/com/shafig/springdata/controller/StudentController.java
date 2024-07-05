package com.shafig.springdata.controller;

import com.shafig.springdata.model.dto.request.StudentRequestDto;
import com.shafig.springdata.model.dto.request.StudentSaveDto;
import com.shafig.springdata.model.entity.Student;
import com.shafig.springdata.repository.StudentRepository;
import com.shafig.springdata.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;

import static com.shafig.springdata.util.constant.Mocks.ALL_STUDENTS_RESPONSE;
import static com.shafig.springdata.util.constant.Mocks.STUDENT_SAVE_EXAMPLE;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<StudentRequestDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @Operation(summary = "save student endpoint",
//            parameters = {@Parameter(name = paramname, example = “example”)},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            examples = @ExampleObject(value = STUDENT_SAVE_EXAMPLE))))

    @PostMapping
    public ResponseEntity<Void> saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.save(studentRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/all")
    public ResponseEntity<Void> saveStudentBulk(@RequestBody StudentSaveDto studentSaveDto) {
        studentService.saveAll(studentSaveDto.getStudents());
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "get students paginated",
            parameters = {@Parameter(name = "page", example = "0"),
                    @Parameter(name = "size", example = "10")},
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(examples = @ExampleObject(value = ALL_STUDENTS_RESPONSE)))})

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(@RequestParam(required = false) int page, @RequestParam int size) {
        return ResponseEntity.ok(studentService.getAllStudents(page, size));
    }

    @GetMapping("plus-one")
    public ResponseEntity<Page<Void>> testPlusOne() {
        studentService.testPlusOneProblem();
        return ResponseEntity.ok().build();
    }



}
