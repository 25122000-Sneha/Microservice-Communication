package com.employee.employeeservice.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Organization {
    private Long id;
    private String organizationName;
    private String organizationDesc;
    private String organizationCode;
    private LocalDateTime createdDate;
}
