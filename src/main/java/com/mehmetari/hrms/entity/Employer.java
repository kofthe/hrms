package com.mehmetari.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employer extends User {
    @NotBlank
    @NotNull
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_email")
    private String companyEmail;
    @NotBlank
    @NotNull
    @Column(name = "company_website")
    private String companyWebSite;
    @NotBlank
    @NotNull
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "is_verified_hrms_worker")
    private Boolean isVerifiedByHrmsWorker;

}
