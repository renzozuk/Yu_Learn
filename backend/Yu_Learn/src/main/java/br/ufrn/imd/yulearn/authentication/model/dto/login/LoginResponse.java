package br.ufrn.imd.yulearn.authentication.model.dto.login;

import java.io.Serializable;
import java.util.List;

public class LoginResponse implements Serializable {

    private String email;
    private String jwtToken;
    private List<String> roles;

    public LoginResponse() {
    }

    public LoginResponse(String email, String jwtToken, List<String> roles) {
        this.email = email;
        this.jwtToken = jwtToken;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
