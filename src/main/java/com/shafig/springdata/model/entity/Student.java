package com.shafig.springdata.model.entity;

import com.shafig.springdata.model.dto.request.StudentRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer age;

    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Laptop> laptops;

    public Student(StudentRequestDto studentDto) {
        this.name = studentDto.getName();
        this.age  = studentDto.getAge();
    }

}
