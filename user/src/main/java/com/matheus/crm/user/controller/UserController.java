package com.matheus.crm.user.controller;

import com.matheus.crm.user.dto.UserDTO;
import com.matheus.crm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public Page<UserDTO> getAllUsers(@PageableDefault(size = 10) Pageable pageable){
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        UserDTO dto = userService.findUserById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto){
        UserDTO user = userService.updateUser(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        UserDTO userDto = userService.findUserById(id);

        if (userDto == null){
            System.out.println("User not found");
            return ResponseEntity.notFound().build();
        }

        userDto.getRoles().clear();
        userService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
