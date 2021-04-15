package org.springboot.bsim.ui.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springboot.bsim.exceptions.service_exception.UserServiceException;
import org.springboot.bsim.exceptions.enumerations.ErrorMessages;
import org.springboot.bsim.service.iservice.IUserService;
import org.springboot.bsim.shared.dto.UserDTO;
import org.springboot.bsim.ui.model.request.UserRequest;
import org.springboot.bsim.ui.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    IUserService userService;

    @Operation(summary = "Get All Registered Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Users Found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Users Not Found", content = @Content)
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getUsers(){
        List<UserDTO> users = userService.getListUser();

        List<UserResponse> val = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for(UserDTO dto : users){
            val.add(mapper.map(dto, UserResponse.class));
        }
        return val;
    }

    @GetMapping(path = "/{username}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse getUserByUsername(@PathVariable String username) throws Exception {
        UserDTO getUser = userService.getUserByUsername(username);
        if(getUser == null)
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        return new ModelMapper().map(getUser, UserResponse.class);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse addNewUser(@RequestBody UserRequest user){
        ModelMapper mapper = new ModelMapper();

        UserDTO userDTO = mapper.map(user, UserDTO.class);
        System.out.println(userDTO.toString());
        UserDTO createdUser = userService.addNewData(userDTO);

        UserResponse resp = mapper.map(createdUser, UserResponse.class);
        return resp;
    }
}
