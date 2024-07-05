package com.shafig.springdata.constant;

import com.shafig.springdata.model.dto.request.StudentRequestDto;
import com.shafig.springdata.model.entity.Student;

import java.time.LocalDateTime;

public class Mocks {

    public static final Long ID_JILL = 38L;

    public static final Student STUDENT_JILL_ENTITY = Student.builder()
            .id(ID_JILL)
            .name("Jill")
            .age(14)
            .createdDateTime(LocalDateTime.now())
            .updatedDateTime(LocalDateTime.now())
            .build();

    public static final StudentRequestDto STUDENT_JILL_DTO = StudentRequestDto.builder()
            .name("Jill")
            .age(14)
            .build();

}
