package com.mehmetari.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
@Table(name = "employees")
public class Employee extends User {

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @NotNull
    private String firstName;

    @Column(name = "last_name" ,nullable = false)
    @NotNull
    @NotBlank
    private String lastName;

}
