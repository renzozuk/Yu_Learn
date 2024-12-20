package br.ufrn.imd.learningplatform.authentication.model.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String email;
    private String name;
    private List<String> authorities;

    public UserDTO() {
    }

    public UserDTO(String id, String email, String name, List<String> authorities) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}