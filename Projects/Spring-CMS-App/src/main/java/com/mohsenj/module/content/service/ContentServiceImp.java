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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class ContentServiceImp implements ContentService{

	@Autowired
	private ContentRepository contentRepository;
	@Autowired 
	private ServletContext servletContext;
	
	final int MODULE_ID = 3;
	
	@Autowired
	private CategoryService categoryService;
	
	private final String UPLOAD_FILE_PATH = "file/module/content";//"src/main/resources/static/file/module/content";

	public void save(Content content, MultipartFile file) {
		
		if (!file.isEmpty()) {
			System.out.println("not empty file");	
			
		//	String filePathToGraphsDir = servletContext.getRealPath("/file/content/");
			
			/*String orgName = file.getOriginalFilename();
			// the leading slash is important
			String filePath = "/Uploads/MyUploads/"+ new Date().getTime()+orgName; 
			File dest = new File(req.getServletContext().getResource(filePath).toURI());
			file.transferTo(dest);*/
			
			FileUploadUtils fileUploadHelper = new FileUploadUtils();
			content.setFileName(fileUploadHelper.process(file, UPLOAD_FILE_PATH));
			
			
		} else {
			System.out.println("empty file");
		}
		// slugify
		content.setSlug(StringUtils.slugify( content.getTitle()) );
		
		// content status
		content.setStatus(1);
		
	//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//System.out.println(); //2016/11/16 12:08:43
		
		content.setCreatedAt(date);
		
		contentRepository.save(content);
	}
	
	
	public Content findByIdForShow(Long id) {
		
		Content content = contentRepository.findByIdForShow(id);
		
		return content;
	}
	
	public Content findById(Long id) {
		
		Content content = contentRepository.findById(id);
		
		return content;
	}
	
	public void update(Content content, MultipartFile file, Map<String, String[]> parameterMap) {
		
		
		if (!file.isEmpty()) {
			System.out.println("not empty file");	
			FileUploadUtils fileUploadHelper = new FileUploadUtils();
			content.setFileName(fileUploadHelper.process(file, UPLOAD_FILE_PATH));

		} else {
			content.setFileName(parameterMap.get("old_file")[0]);
			System.out.println("empty file");
		}
		// slugify
		content.setSlug(StringUtils.slugify( content.getTitle()) );
		
		// content status
		content.setStatus(1);
		
		//Date date = new Date();
	   //content.setCreatedAt(date);
		contentRepository.update(content.getId(), content.getTitle(), content.getSlug(),
				content.getContent(), content.getCategory(), content.getFileName());
	}
	
	public Page<Content> findAll(Pageable pageRequest) {
        return contentRepository.findAll(pageRequest);
    }


	public void deleteById(Long id) {

		// delete content picture if exist
		
		Content content = contentRepository.findOne(id);
		
		if(content == null) {
			throw new ResourceNotFoundException("");
		}
		
		if(content.getFileName() != "" && content.getFileName() != null) {
			// delete file from filesystem
			Path path = Paths.get(UPLOAD_FILE_PATH);
			
			if( Files.exists(path.resolve(content.getFileName()))) {
				try {
					Files.delete(path.resolve(content.getFileName()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// throw 504 error
				}
			}
			
		}
		
		contentRepository.delete(id);
		
		
	}
	
	public String getCategorySelectOptionRaw() {
		
		return getCategorySelectOption(0, 0);
	}

	public String getCategorySelectOption(Integer selected_id, Integer parent) {
		
		List<Category> entities = categoryService.findByModuleId(MODULE_ID);
		
		HiararchyUtils hiararchyUtils = new HiararchyUtils();
		String selectOptions = hiararchyUtils.getHForSelect(entities, selected_id, parent);
		
		return selectOptions;
	}

	@Override
	public Page<Content> getForCatListContents(Integer categoryId, int page, int pageSize) {

		Pageable pageRequest = new PageRequest(page-1, pageSize/*pageSize*/, Sort.Direction.DESC, "id");
		Page<Content> result = contentRepository.findForCatListContents(categoryId, pageRequest);

		return result;
	}
	
	@Override
	public Page<Content> getLatestContent(int size) {
		
		int page = 0;
		Pageable pageRequest = new PageRequest(page, size, Sort.Direction.ASC, "id");
		
		return contentRepository.getLatestContent(pageRequest);
	//	return null;
		
	}

	
}
