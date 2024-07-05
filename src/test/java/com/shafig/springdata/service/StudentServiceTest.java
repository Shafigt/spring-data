package com.shafig.springdata.service;

import com.shafig.springdata.model.dto.request.StudentRequestDto;
import com.shafig.springdata.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static com.shafig.springdata.constant.Mocks.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void getByIdTest() {
        when(studentRepository.findById(eq(ID_JILL))).thenReturn(Optional.of(STUDENT_JILL_ENTITY));

        when(modelMapper.map(any(), eq(StudentRequestDto.class))).thenReturn((STUDENT_JILL_DTO));

        StudentRequestDto response = studentService.getById(ID_JILL);

        assertEquals(response, STUDENT_JILL_DTO);

        verify(studentRepository).findById(ID_JILL);
    }

}
