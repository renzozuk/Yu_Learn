package br.ufrn.imd.learningplatform.authentication.model.dto.register;

import java.io.Serializable;
import java.util.List;

public class RegisterResponse implements Serializable {

    private String email;
    private String name;
    private List<String> roles;

    public RegisterResponse() {
    }

    public RegisterResponse(String name, String email, List<String> roles) {
        this.email = email;
        this.name = name;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
