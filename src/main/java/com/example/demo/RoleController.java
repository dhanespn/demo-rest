package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<ResponsePojo> getRoles(){
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), roleRepository.findAll()));
    }

    @PostMapping
    public ResponseEntity<ResponsePojo> saveRoles(@RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponsePojo(HttpStatus.CREATED.value(), roleRepository.save(role)));
    }


}
