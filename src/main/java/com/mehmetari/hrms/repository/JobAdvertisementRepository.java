package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {

}
