package org.springboot.bsim.service.impl;

import org.modelmapper.ModelMapper;
import org.springboot.bsim.io.entity.UserEntity;
import org.springboot.bsim.io.repository.UserRepository;
import org.springboot.bsim.service.iservice.IUserService;
import org.springboot.bsim.shared.dto.UserDTO;
import org.springboot.bsim.shared.utils.GenerateRandomPublicId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<UserDTO> getListUser(){
        List<UserDTO> value = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        List<UserEntity> users = userRepository.findAll();

        for(UserEntity userEntity : users){
            value.add(mapper.map(userEntity, UserDTO.class));
        }
        return value;
    }

    @Override
    public UserDTO getUserByUsername(String userName) {
        UserEntity getUser = userRepository.findByUsername(userName);
        if(getUser == null)
            return null;
        return new ModelMapper().map(getUser, UserDTO.class);
    }

    @Override
    public UserDTO addNewData(UserDTO user) {
        // Generate Public Id
        user.setUserId(generateRandomPublicId.generateUserId(35));

        ModelMapper mapper = new ModelMapper();
        UserEntity entity = mapper.map(user, UserEntity.class);

        UserEntity storedData = userRepository.save(entity);

        UserDTO value = mapper.map(storedData, UserDTO.class);
        return value;
    }
}
