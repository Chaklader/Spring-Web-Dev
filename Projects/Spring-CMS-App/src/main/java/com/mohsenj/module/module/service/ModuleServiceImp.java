package com.mohsenj.module.module.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mohsenj.module.module.repository.ModuleRepository;
import com.mohsenj.module.module.model.Module;

@Service
public class ModuleServiceImp implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public List<Module> findAll() {

		return moduleRepository.findAll();
	}

}
