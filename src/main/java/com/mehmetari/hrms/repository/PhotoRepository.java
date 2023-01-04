package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    Photo findBySeekerId(int id);


}
