package br.ufrn.imd.yulearn.domain.repositories;

import br.ufrn.imd.yulearn.domain.model.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
