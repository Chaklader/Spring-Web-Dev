package com.mohsenj.module.slideshow.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryServiceImp;
import com.mohsenj.module.slideshow.model.Slideshow;
import com.mohsenj.module.slideshow.model.SlideshowItem;
import com.mohsenj.module.slideshow.repository.SlideshowRepository;

@RunWith(MockitoJUnitRunner.class)
public class SlideshowServiceTest {

	@Mock
	SlideshowRepository slideshowrepository;
	
	@InjectMocks
	private SlideshowService slideshowService = new SlideshowServiceImp();
	
	private Map<String, String[]> parameters;
	
	// slideshow
	private final Integer slideshowId=1;
	private Slideshow slideshow;
	// slideshowItem
	private final Integer slideshowItemId = 5;
	private final Integer slideshowItemId2 = 6;
	
	SlideshowItem slideshowItem;
	
	SlideshowItem slideshowItem2;
	
	
	@Before
	public void setup() {
		
		parameters = new HashMap<String, String[]>();
		
		// slideshow
		slideshow = new Slideshow();
		slideshow.setId(slideshowId);
		// slideshowItem
		slideshowItem = new SlideshowItem(slideshow);
		slideshowItem.setId(slideshowItemId);
		
		slideshowItem2 = new SlideshowItem(slideshow);
		slideshowItem2.setId(slideshowItemId2);
	}
	
	@Test
	public void findAll_testCallReturnRepositoryResult() {

		
		List<Slideshow> entities = Arrays.asList(slideshow);
        when(slideshowrepository.findAll()).thenReturn(entities);
        
        List<Slideshow> results = slideshowService.findAll();
		
		verify(slideshowrepository).findAll();
		assertEquals(entities, results);
	}
	
	@Test
	public void getForEdit_testReturn() {
		
		SlideshowItem slideshowItem = new SlideshowItem(slideshow);
		
		when(slideshowrepository.findSlideshowWithItemsById(slideshowId)).thenReturn(slideshow);
		//
		Slideshow result = slideshowService.getForEditItems(slideshowId);
		
		//
		verify(slideshowrepository).findSlideshowWithItemsById(slideshowId);
		assertEquals(slideshow, result);
		assertEquals(slideshow.getSlideshowItems(), result.getSlideshowItems());
	}
	
	@Test
	public void updateSlideshowItems_testNoSlideItemThenDeleteExistFromPersistence() {		
				
		when(slideshowrepository.findSlideshowWithItemsById(slideshowId)).thenReturn(slideshow);
		//
		slideshowService.updateSlideshowItems(slideshowId, parameters, null);
		
		//
		verify(slideshowrepository).findSlideshowWithItemsById(slideshowId);
		// verify delete
		//verify(slideshowrepository).delete(slideshowItemId);
	//	verify(slideshowService).deleteNotFoundItems(slideshowId, parameters);

	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void updateSlideshowItems_ifSlideshowNotFoundThrowExeption() {
		// initialize		
		when(slideshowrepository.findSlideshowWithItemsById(slideshowId)).thenReturn(null);
		
		// 
		slideshowService.updateSlideshowItems(slideshowId, parameters, null);
		
		// assertion
	}
	
	@Test
	public void findDeletedItems_testNoParametersThenReturnAllItems() {
		//
		Set<SlideshowItem> slideshowItems = slideshowService.findDeletedItems(slideshow, parameters);
		
		//
		assertEquals(slideshow.getSlideshowItems(), slideshowItems);
	}
	
	@Test
	public void findDeletedItems_allItemsExistReturnNothing() {
		
		String[] itemIds = {slideshowItemId.toString(), slideshowItemId2.toString()};
		parameters.put("itemIds", itemIds);
		
		//
		Set<SlideshowItem> slideshowItems = slideshowService.findDeletedItems(slideshow, parameters);
		Set<SlideshowItem> deletedItems = new HashSet<SlideshowItem>();

		//
		assertEquals(deletedItems, slideshowItems);
	}

	
	@Test
	public void deletedItems_() {
		
		Set<SlideshowItem> deletedItems = new HashSet<SlideshowItem>();
		deletedItems.add(slideshowItem);
		deletedItems.add(slideshowItem2);
		
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(slideshowItemId);
		ids.add(slideshowItemId2);
		
		//
		slideshowService.deleteItems(slideshow, deletedItems);
		


		// assertion
		verify(slideshowrepository).deleteItems(ids);
		Boolean r = slideshow.getSlideshowItems().isEmpty();
		assertTrue("", r);
	}
	
	@Test
	public void deletedItems_IfNothingToDeleteJustReturn() {
		
		Set<SlideshowItem> deletedItems = new HashSet<SlideshowItem>();
		Set<Integer> deletedIds= new HashSet<Integer>();
		//
		slideshowService.deleteItems(slideshow, deletedItems);
		
		
		verify(slideshowrepository, never()).deleteItems(deletedIds);
	}
	
	@Test
	public void addNewSlideshowItemsFromParameter_NoNewItem() {
				
		slideshowService.addNewSlideshowItemsFromParameter(slideshow, parameters, null);
		
		//
		assertEquals(2, slideshow.getSlideshowItems().size());
	}
	
	@Test
	public void addNewSlideshowItemsFromParameter_()
	{
		String title1 = "test1";
		String title2 = "test2";
		String[] newItemsTitle = {title1, title2};
		parameters.put("newItemsTitle", newItemsTitle);
		String[] ordering = {"1", "2"};
		parameters.put("newItemsOrdering", ordering);
		//
		slideshowService.addNewSlideshowItemsFromParameter(slideshow, parameters, null);
		
		// assertion
			/*cloneSlideshow = 
			SlideshowItem newSlideshowItem_1 = new SlideshowItem(slideshow);
			newSlideshowItem_1.setTitle(title1);*/
		assertEquals(4, slideshow.getSlideshowItems().size());
	}
	
	@Test
	public void updateModifiedItemsFromParameters_checkIfItemsUpdated()
	{
		String title1 = "test1";
		String title2 = "test2";
		Integer ordering1 = 100;
		Integer ordering2 = 101;
		String[] newItemsTitle = {title1, title2};
		parameters.put("itemTitles", newItemsTitle);
		String[] itemOrderings = {ordering1.toString(), ordering2.toString()};
		parameters.put("itemOrderings", itemOrderings);
		String[] newItemsId = {slideshowItemId.toString(), slideshowItemId2.toString()};
		parameters.put("itemIds", newItemsId);
		
		//
		slideshowService.updateModifiedItemsFromParameters(slideshow, parameters);
		
		// assertion

		assertEquals(title1, slideshowItem.getTitle());
		assertEquals(title2, slideshowItem2.getTitle());
		
		assertEquals(ordering1, slideshowItem.getOrdering());
		assertEquals(ordering2, slideshowItem2.getOrdering());
	}
	
	@Test
	public void updateModifiedItemsFromParameters_checkIfNoNewItemUpdateDoNothingAndNoError()
	{
		
		//
		slideshowService.updateModifiedItemsFromParameters(slideshow, parameters);
		
		// assertion
		assertEquals(null, slideshowItem.getTitle());
	}
}
