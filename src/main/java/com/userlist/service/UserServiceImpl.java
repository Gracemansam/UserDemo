package com.userlist.service;

import com.userlist.converter.UserConverter;
import com.userlist.dto.UserDto;
import com.userlist.exception.BusinessException;
import com.userlist.exception.ErrorModel;
import com.userlist.model.User;
import com.userlist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    @Override
    public UserDto saveUser(UserDto userDto) {
        Optional<User> existinUser = userRepository.findByEmail(userDto.getEmail());
        if(existinUser.isPresent()){
            ErrorModel errorModel =new ErrorModel();
            errorModel.setErrorCode("404");
            errorModel.setErrorMessage("Email already exist");
            throw new BusinessException(errorModel);

        }
        User user = userConverter.convertDtoToEntity(userDto);
        userRepository.save(user);
        UserDto userDto1 = userConverter.convertEntityToDto(user);


        return userDto1;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>allUser =userRepository.findAll();
        List<UserDto>userDtosList = new ArrayList<>();
        for(User user : allUser){
            UserDto userDto = userConverter.convertEntityToDto(user);
            userDtosList.add(userDto);
        }
        return userDtosList;

    }

    @Override
    public UserDto getuserById(Long id) {
        Optional<User>findUser = userRepository.findById(id);
        if(!findUser.isPresent()){
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode("404");
            errorModel.setErrorMessage("User not Found");
            throw new BusinessException(errorModel);
        }

        User user = findUser.get();
        UserDto userDto = userConverter.convertEntityToDto(user);
        return userDto;
    }


}
