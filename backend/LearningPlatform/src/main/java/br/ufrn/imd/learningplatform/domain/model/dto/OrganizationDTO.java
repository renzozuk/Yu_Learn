package br.ufrn.imd.learningplatform.domain.model.dto;

import br.ufrn.imd.learningplatform.authentication.model.dto.UserDTO;

import java.util.List;

public class OrganizationDTO {

    private String id;
    private String name;
    private List<UserDTO> users;

    public OrganizationDTO() {

    }

    public OrganizationDTO(String id, String name, List<UserDTO> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
