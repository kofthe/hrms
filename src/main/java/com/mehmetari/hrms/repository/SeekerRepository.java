package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekerRepository extends JpaRepository<Seeker, Integer> {


    boolean existsSeekerByEmail(String email);

    boolean existsSeekerByIdentityNumber(String identityNumber);




}
