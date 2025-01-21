package br.ufrn.imd.learningplatform.domain.repositories;

import br.ufrn.imd.learningplatform.domain.model.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
