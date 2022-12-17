package com.mehmetari.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mehmetari.hrms.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class Seeker extends User {


    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "birth_year")
    private Integer birthYear;
    @NotNull
    @NotBlank
    @Column(name = "identity_number", unique = true,nullable = false)
    private String identityNumber;

}
