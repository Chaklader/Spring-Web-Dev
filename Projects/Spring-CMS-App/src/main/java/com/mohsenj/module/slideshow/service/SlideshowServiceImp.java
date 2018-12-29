package com.mohsenj.module.slideshow.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.module.slideshow.model.Slideshow;
import com.mohsenj.module.slideshow.model.SlideshowItem;
import com.mohsenj.module.slideshow.repository.SlideshowRepository;
import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.FileUploadUtils;
import com.mohsenj.core.util.StringUtils;

@Service
public class SlideshowServiceImp implements SlideshowService {

	
	private SlideshowRepository slideshowRepository;
	private FileUploadUtils fileUploadUtils;

	private final String newItemsTitle = "newItemsTitle";
	private final String newItemsOrdering = "newItemsOrdering";
	@Autowired
	public void setSlideshowRepository(SlideshowRepository slideshowRepository) {
		this.slideshowRepository = slideshowRepository;
	}
	
	@Autowired
	public void setFileUploadUtils(FileUploadUtils fileUploadUtils) {
		this.fileUploadUtils =fileUploadUtils;
	}

	public List<Slideshow> findAll() {

		return slideshowRepository.findAll();
	}

	@Override
	public Slideshow getForEditItems(Integer slideshowId) {

		return slideshowRepository.findSlideshowWithItemsById(slideshowId);
				
	}

	@Override
	public void updateSlideshowItems(Integer slideshowId, Map<String, String[]> parameters, MultipartFile[] newItemsFiles) {

		Slideshow slideshow = slideshowRepository.findSlideshowWithItemsById(slideshowId);
		
		if(slideshow == null) {
			throw new ResourceNotFoundException("slideshow Not Found");
		}
		
		// delete
		deleteNotFoundItems(slideshow, parameters);
		
		// add new items
		addNewSlideshowItemsFromParameter(slideshow, parameters, newItemsFiles);
		
		//
		updateModifiedItemsFromParameters(slideshow, parameters);

		slideshowRepository.save(slideshow);
		
	//	System.out.println(slideshow);
	//	System.out.println(slideshow.getSlideshowItems());
	}

	@Override
	public void deleteNotFoundItems(Slideshow slideshow, Map<String, String[]> parameters) {

		Set<SlideshowItem> deletedItems = findDeletedItems(slideshow, parameters);
		deleteItems(slideshow, deletedItems);
	}

	@Override
	public Set<SlideshowItem> findDeletedItems(Slideshow slideshow, Map<String, String[]> parameters) {

		Set<SlideshowItem> deletedItems = new HashSet<SlideshowItem>();
		
		if(parameters.get("itemIds") == null ) {
			for(SlideshowItem item : slideshow.getSlideshowItems()) {
				deletedItems.add(item);
			}
			return deletedItems;
		}
			
		for(SlideshowItem item : slideshow.getSlideshowItems()) {
			boolean exist=false;
			for(String itemId: parameters.get("itemIds")) {
				if(item.getId() == Integer.parseInt(itemId)) {
					exist=true;
				}
			}
		//	exist=true;
			if(exist == false) {
				deletedItems.add(item);
			}
		}
		
		return deletedItems;
	}

	@Override
	public void deleteItems(Slideshow slideshow, Set<SlideshowItem> deletedItems) {

		if(deletedItems.isEmpty()) {
			return;
		}
		Set<Integer> deleteIds = new HashSet<Integer>();
		
		for(SlideshowItem item : deletedItems) {
			
			slideshow.removeSlideshowItem(item);
			deleteIds.add(item.getId());
			
			
		}
		
		slideshowRepository.deleteItems(deleteIds);
		
	}

	@Override
	public void addNewSlideshowItemsFromParameter(Slideshow slideshow, Map<String, String[]> parameters, MultipartFile[] newItemsFiles) {

		if(!parameters.containsKey(newItemsTitle) || parameters.get(newItemsTitle) == null) {
			return;
		}
		
		int size = parameters.get(newItemsTitle).length;
		 
		for(int i=0; i<size; i++) {
			String title = parameters.get(newItemsTitle)[i];
			int ordering = Integer.parseInt(parameters.get(newItemsOrdering)[i]);
			
			// upload file
			String fileName=null;
			if(newItemsFiles != null && newItemsFiles[i] != null) {
				String dir = "file/module/slideshow/"+slideshow.getId();
				fileName = fileUploadUtils.process(newItemsFiles[i], dir);
			}
			
			
			SlideshowItem newSlideshowItem = new SlideshowItem(slideshow, title, fileName);
			newSlideshowItem.setOrdering(ordering);
		}
		
		System.out.println(slideshow.getSlideshowItems());
	}

	@Override
	public void updateModifiedItemsFromParameters(Slideshow slideshow, Map<String, String[]> parameters) {
		
		if(!parameters.containsKey("itemIds") || parameters.get("itemTitles") == null ||
				parameters.get("itemOrderings") == null) {
			return;
		}
		
		int size = parameters.get("itemIds").length;
		 
		for(int i=0; i<size; i++) {
			String title = parameters.get("itemTitles")[i];
			int id = Integer.parseInt(parameters.get("itemIds")[i]);
			int ordering = Integer.parseInt(parameters.get("itemOrderings")[i]);
			
			System.out.println("id is null? "+id);
			
			// find related slideshowItem and update it
			for(SlideshowItem item : slideshow.getSlideshowItems()) {
				
				System.out.println("my id id: "+item.getId());
				if(item.getId() == null) {
					continue;
				}
				else if(item.getId() == id) {
					item.setTitle(title);
					item.setOrdering(ordering);
					
					break;
				}
			}
		}
	}

	@Override
	public Slideshow getSlideshowForShowById(int id) {

		return slideshowRepository.getSlideshowForShowById(id);
		
	}
	
}
