package br.ufrn.imd.learningplatform.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.go.entities.Modul;
import com.example.go.repositories.ModulRepository;

@Service
public class ModulService {
	
	private ModulRepository modulRepository;
	
	public ModulService(ModulRepository modulRepository) {
		this.modulRepository = modulRepository;
}
	
	
	public List<Modul> create(Modul modul){
		modulRepository.save(modul);
		return list();
	}
	
	public List<Modul> list(){
		return modulRepository.findAll();
	}
	
	public List<Modul> update(Modul modul){
		modulRepository.save(modul);
		return list();
	}
	
	public List<Modul> delete(String id){
		modulRepository.deleteById(id);
		return list();
	}

}
