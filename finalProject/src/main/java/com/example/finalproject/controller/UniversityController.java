//package com.example.finalproject.controller;
//
//import com.example.finalproject.dto.Api;
//import com.example.finalproject.service.ProfessorsService;
//import com.example.finalproject.service.UniversityService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/university")
//public class UniversityController {
//    private final UniversityService universityService;
//
//
//    @GetMapping
//    public ResponseEntity getUniversity() {
//        return ResponseEntity.status(200).body(universityService.getUniversity());
//    }
//
//}
