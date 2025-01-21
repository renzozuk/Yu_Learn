package br.ufrn.imd.yulearn.authentication.model.dto.register;

import java.io.Serial;
import java.io.Serializable;

public class RegisterRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String email;
    private String name;
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String email, String name, String password, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
