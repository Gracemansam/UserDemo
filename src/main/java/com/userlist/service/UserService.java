package com.userlist.service;

import com.userlist.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    List<UserDto> getAllUser();

    UserDto getuserById(Long id);
}
