package com.example.finalproject.controller;
import com.example.finalproject.dto.Api;
import com.example.finalproject.dto.RegisterForm;
import com.example.finalproject.model.User;
import com.example.finalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm) {
        userService.register(registerForm);
        return ResponseEntity.status(201).body("Register done !");
    }

    @PostMapping("/login")
    public ResponseEntity<Api> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Welcome back",200));
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Api> updateUser(@RequestBody @Valid User user, @PathVariable Integer id){
        userService.updateUser(user, id);
        return ResponseEntity.status(201).body(new Api("User updated",201));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Api> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(201).body(new Api("User deleted !", 201));
    }

}
