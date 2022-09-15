package com.example.finalproject.controller;
import com.example.finalproject.dto.Api;
import com.example.finalproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")

public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity getAdmin() {
        return ResponseEntity.status(200).body(adminService.getAdmin());
    }


    @GetMapping("/login")
    public ResponseEntity logInAdmin() {
        return ResponseEntity.status(200).body(new Api("Hey admin", 201));
    }


}
