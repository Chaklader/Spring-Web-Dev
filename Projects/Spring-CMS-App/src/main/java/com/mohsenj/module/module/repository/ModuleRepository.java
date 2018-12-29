package com.mohsenj.module.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohsenj.module.module.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{
	
}
