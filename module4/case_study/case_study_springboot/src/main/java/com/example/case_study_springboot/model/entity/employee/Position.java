package com.example.case_study_springboot.model.entity.employee;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String positionName;
    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    public Position() {
    }

}
