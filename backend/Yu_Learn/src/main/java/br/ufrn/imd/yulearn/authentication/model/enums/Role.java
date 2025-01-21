package br.ufrn.imd.yulearn.authentication.model.enums;

public enum Role {

    ROLE_ORGANIZATION("ROLE_ORGANIZATION"),
    ROLE_STUDENT("ROLE_STUDENT"),
    ROLE_TEACHER("ROLE_TEACHER"),
    ROLE_MANAGER("ROLE_MANAGER");

    private String role;

    Role(String role) {
        this.role = role;
    }

}
