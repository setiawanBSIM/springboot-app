package org.springboot.bsim.service.iservice;

import org.springboot.bsim.shared.dto.UserDTO;

import java.util.List;

public interface IUserService {
    // Multi Value
    List<UserDTO> getListUser();

    // Single Value
    UserDTO getUserByUsername(String userName);
    UserDTO addNewData(UserDTO user);

}
