package br.ufrn.imd.learningplatform.media.repositories;

import br.ufrn.imd.learningplatform.media.model.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, String>{ }