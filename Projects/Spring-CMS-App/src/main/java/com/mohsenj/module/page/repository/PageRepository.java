package com.mohsenj.module.page.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.module.model.Module;
import com.mohsenj.module.page.model.Page;

public interface PageRepository extends JpaRepository<Page, Integer>{

	Page findById(int i);

	Page findTop1ByOrderByIdDesc();

}
