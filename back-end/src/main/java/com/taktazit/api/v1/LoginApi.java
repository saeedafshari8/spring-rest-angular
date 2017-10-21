package com.taktazit.api.v1;

import com.taktazit.api.v1.mapper.UserMapper;
import com.taktazit.datatransferobject.UserDTO;
import com.taktazit.domainobject.User;
import com.taktazit.service.SecurityService;
import com.taktazit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/login")
public class LoginApi {
    @Autowired
    private SecurityService securityService;

    @PostMapping()
    public boolean login(@Valid @RequestBody UserDTO userDTO) {
        User user = UserMapper.makeUser(userDTO);

        securityService.autoLogin(user.getUsername(), user.getPassword());

        return true;
    }
}
