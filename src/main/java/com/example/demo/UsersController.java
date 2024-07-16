package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{username}")
    public ResponseEntity<?> fetchUserByUsernameEndpoint(@PathVariable String username) {
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), usersService.fetchUserByUsername(username)));
    }

    @PostMapping
    public ResponseEntity<?> addUserEndpoint(@RequestBody UsersPojo usersPojo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponsePojo(HttpStatus.CREATED.value(), usersService.addNewUser(usersPojo)));
    }


    @GetMapping
    public ResponseEntity<?> fetchAllUsersEndpoint() {
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), usersService.fetchAllUsers()));
    }
}