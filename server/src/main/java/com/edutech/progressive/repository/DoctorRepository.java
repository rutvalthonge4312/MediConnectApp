package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Doctor findByDoctorId(int doctorId);

    List<Doctor> findAllByOrderByExperienceAsc();
}
