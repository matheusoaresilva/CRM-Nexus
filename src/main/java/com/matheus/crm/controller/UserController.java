package com.matheus.crm.controller;

import com.matheus.crm.dto.UserModelDTO;
import com.matheus.crm.repository.UserRepository;
import com.matheus.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/all")
    public ResponseEntity<List<UserModelDTO>> findAllUsers() {
        List<UserModelDTO> users = userService.findAll();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }


    @RequestMapping(
            value = "/find/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserModelDTO> findById(@PathVariable(name = "id") Long id){
        UserModelDTO user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(
            value = "/update/{id}", consumes = "application/json" , method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<UserModelDTO> updateUser(@PathVariable(name = "id") Long id , @RequestBody UserModelDTO userDTO) {
        userDTO  = userService.updateUser(id, userDTO);

        return ResponseEntity.ok().body(userDTO);
    }


    @RequestMapping(
            value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
