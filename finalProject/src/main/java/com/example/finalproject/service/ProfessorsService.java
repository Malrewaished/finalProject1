package com.example.finalproject.service;

import com.example.finalproject.dto.RegisterForm;
import com.example.finalproject.model.Professors;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.ProfessorsRepository;
import com.example.finalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorsService {

    private final ProfessorsRepository professorsRepository;
    public List<Professors> getProfessors() {

    return professorsRepository.findAll();

    }

//    public void findProfessorsByUniversityName(String universityName) {
//        professorsRepository.findProfessorsByUniversityName(universityName);
//    }
}
