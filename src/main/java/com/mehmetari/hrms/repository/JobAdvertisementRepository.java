package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {

    JobAdvertisement getJobAdvertisementByIdAndEmployer_Id(int jobAdvertisementId, int employerId);

    List<JobAdvertisement> getByEmployerId(int userId);
}
