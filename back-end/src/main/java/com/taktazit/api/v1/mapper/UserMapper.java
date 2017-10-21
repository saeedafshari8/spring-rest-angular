package com.taktazit.api.v1.mapper;

import com.taktazit.datatransferobject.UserDTO;
import com.taktazit.domainobject.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static User makeUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public static UserDTO makeUserDTO(User user) {
        UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
                .setId(user.getId())
                .setPassword(user.getPassword())
                .setUsername(user.getUsername());

        return userDTOBuilder.createUserDTO();
    }

    public static List<UserDTO> makeUserDTOList(Collection<User> users) {
        return users.stream()
                .map(UserMapper::makeUserDTO)
                .collect(Collectors.toList());
    }
}
