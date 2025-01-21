package br.ufrn.imd.yulearn.domain.model.dto;

import br.ufrn.imd.yulearn.authentication.model.dto.UserDTO;

import java.util.List;

public class ManagerDTO extends UserDTO {

    public ManagerDTO() {
    }

    public ManagerDTO(String id, String email, String name, List<String> authorities, OrganizationDTO organization) {
        super(id, email, name, authorities, organization);
    }
}
