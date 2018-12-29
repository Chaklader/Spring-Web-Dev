package com.mohsenj.module.content.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.content.repository.ContentRepository;
import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.FileUploadUtils;
import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.core.util.StringUtils;

@Service
public interface ContentService {

	public void save(Content content, MultipartFile file);
		
	public void update(Content content, MultipartFile file, Map<String, String[]> parameterMap);
	
	public Page<Content> findAll(Pageable pageRequest);

	public void deleteById(Long id);
	
	public String getCategorySelectOptionRaw();

	public String getCategorySelectOption(Integer selected_id, Integer parent);

	public Content findByIdForShow(Long id);
	
	public Content findById(Long id);

	public Page<Content> getForCatListContents(Integer categoryId, int page, int pageSize);

	public Page<Content> getLatestContent(int size);

}
