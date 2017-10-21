package com.taktazit.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @JsonIgnore
    private Long id;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;

    public UserDTO(){

    }

    private UserDTO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserDTOBuilder newBuilder() {
        return new UserDTOBuilder();
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class UserDTOBuilder {
        private Long id;
        private String username;
        private String password;

        public UserDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDTOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDTO createUserDTO() {
            return new UserDTO(id, username, password);
        }
    }
}
