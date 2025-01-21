package br.ufrn.imd.yulearn.authentication.model.dto;

import br.ufrn.imd.yulearn.domain.model.dto.OrganizationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private OrganizationDTO organization;

    public UserDTO() {
    }

    public UserDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.authorities = authorities;
        this.organization = organization;
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

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }
}