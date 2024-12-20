package br.ufrn.imd.learningplatform.authentication.model.enums;

public enum Role {

    ROLE_COMPANY("ROLE_COMPANY"),
    ROLE_STUDENT("ROLE_STUDENT"),
    ROLE_MANAGER("ROLE_MANAGER");

    private String role;

    Role(String role) {
        this.role = role;
    }

}
