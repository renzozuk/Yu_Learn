package br.ufrn.imd.yulearn.media.repositories;

import br.ufrn.imd.yulearn.media.model.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, String>{ }