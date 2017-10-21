package com.taktazit.api.v1;

import com.taktazit.api.v1.mapper.UserMapper;
import com.taktazit.datatransferobject.UserDTO;
import com.taktazit.domainobject.User;
import com.taktazit.service.SecurityService;
import com.taktazit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Secured("ADMIN")
    @GetMapping("/{username}")
    public UserDTO getUser(@Valid @PathVariable String username) {
        User user = userService.findByUsername(username);
        return UserMapper.makeUserDTO(user);
    }

    @PostMapping()
    public boolean register(@Valid @RequestBody UserDTO userDTO) {
        User user = UserMapper.makeUser(userDTO);
        userService.save(user);

        securityService.autoLogin(userDTO.getUsername(), userDTO.getPassword());

        return true;
    }
}
