package com.ra.controller.admin;

import com.ra.model.dto.AccountRequestDTO;
import com.ra.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/admin/account")
@RestController
public class AccountController {
    @Autowired
    private AuthService authService;
    @GetMapping
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(authService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountRequestDTO accountRequestDTO){

        return new ResponseEntity<>(authService.creatAccount(accountRequestDTO),HttpStatus.CREATED);
    }
}
