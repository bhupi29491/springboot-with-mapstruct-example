package com.bhupi.mapstruct.service;

import com.bhupi.mapstruct.dto.UserDTO;
import com.bhupi.mapstruct.entity.User;
import com.bhupi.mapstruct.mapper.UserMapper;
import com.bhupi.mapstruct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public User saveUser(UserDTO userDTO) {
        return userRepository.save(userMapper.toEntity(userDTO));
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(new UserDTO());
    }

    public List<UserDTO> getUserList() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }
}
