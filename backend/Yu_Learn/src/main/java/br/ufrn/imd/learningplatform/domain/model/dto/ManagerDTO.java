package br.ufrn.imd.learningplatform.domain.model.dto;

import br.ufrn.imd.learningplatform.authentication.model.dto.UserDTO;

import java.util.List;

public class ManagerDTO extends UserDTO {

    public ManagerDTO() {
    }

    public ManagerDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization) {
        super(id, email, name, authorities, organization);
    }
}
