package com.weeklyTest.JobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    private Long jobId;

    private  String jobTitle;
    private String jobDescription;
    private  String companyLocation;

    @Min(value = 20000, message = "Salary must be at least 20000")
    private Double salary;

    @Email(message = "Email should be in email format.")
    private String companyEmail;
    private String companyName;
    private String employerName;

    @Enumerated(EnumType.STRING)
    private Type jobType;

    private LocalDate appliedDate;
}
