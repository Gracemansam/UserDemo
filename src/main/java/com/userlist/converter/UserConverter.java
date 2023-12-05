package com.userlist.converter;

import com.userlist.dto.UserDto;
import com.userlist.model.User;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertDtoToEntity(UserDto userDto){
        User user = User.builder().
                userName(userDto.getUserName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .status(userDto.getStatus())
                .build();

                return user;


    }

    public UserDto convertEntityToDto(User user){
        UserDto userDto = UserDto.builder().
                 id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .build();

        return userDto;


    }




}
