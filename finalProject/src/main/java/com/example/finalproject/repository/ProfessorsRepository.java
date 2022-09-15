package com.example.finalproject.repository;

import com.example.finalproject.model.Professors;
import com.example.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorsRepository extends JpaRepository<Professors, Integer> {

    Optional<Professors> findProfessorsByUniversityName(String universityName);

}
