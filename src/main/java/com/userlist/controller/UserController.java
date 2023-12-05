package com.userlist.controller;

import com.userlist.dto.UserDto;
import com.userlist.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    @PostMapping("/save")
    public ResponseEntity<UserDto>saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return  new  ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

@GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>>getAllUser(){
     List <UserDto> userDto = userService.getAllUser();
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    public ResponseEntity<UserDto>getUserById(@PathVariable Long  id){
        UserDto userDto = userService.getuserById(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
