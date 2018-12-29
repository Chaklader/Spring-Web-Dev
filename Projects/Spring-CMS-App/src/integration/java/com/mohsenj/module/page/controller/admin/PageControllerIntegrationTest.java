package com.mohsenj.module.page.controller.admin;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.mohsenj.BaseIntegrationTest;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.repository.PageRepository;

@Transactional
public class PageControllerIntegrationTest extends BaseIntegrationTest{

	private final String contentParamName = "content";
	private final String titleParamName = "title";
	
	@Autowired
	private PageRepository pageRepository;
	
	private Page pageBefore;
	
	@Before
	public void beforeSetUp() {
		
	}
	
	@Test
    public void testCreate() throws Exception {
    	Integer parentId = 1;
        mockMvc.perform(get("/admin/page/create/"))
            .andExpect(status().isOk())
          //  .andExpect(model().attributeExists("data"))
            .andExpect(model().attributeExists("entityForm"))
          //  .andExpect(model().attribute("entityForm", new Page()))
            .andExpect(view().name("admin/module/page/create"))
            .andExpect(content().string(containsString("Page")));
   //         .andExpect(xpath("//input[@name='" + titleParamName + "']").exists());
    	//	.andExpect(xpath("//textarea[@name='" + contentParamName + "']").exists());
    }
	
	@Test
    public void testProcessCreationSuccess() throws Exception {
        mockMvc.perform(post("/admin/page/store")
        			
            .param("title", "testProcessCreationSuccess title")
            .param("content", "testProcessCreationSuccess content")
            .with(csrf())
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(MockMvcResultMatchers.flash().attribute("message", "Successfully created!"));
        
        Page page = pageRepository.findTop1ByOrderByIdDesc();
        
        assertEquals("testProcessCreationSuccess title", page.getTitle());
        assertEquals("testProcessCreationSuccess content", page.getContent());
         
    }
	
	@Test
    public void testProcessCreationWithError() throws Exception {
        mockMvc.perform(post("/admin/page/store")
        			
            .param("title", "")
            .param("content", "")
            .with(csrf())
        )
        .andExpect(model().attributeHasFieldErrors("entityForm", "content"))
        .andExpect(status().isOk())
        .andExpect(view().name("admin/module/page/create"));
         
    }
	
	@Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/admin/page/index")

        )
        .andExpect(model().attributeExists("entities"))
        .andExpect(status().isOk())
        .andExpect(view().name("admin/module/page/index"))
        .andExpect(content().string(containsString("page title 1")))
        /*.andExpect(content().string(containsString("page title 2")))*/
        .andExpect(content().string(containsString("/admin/page/edit/1")));

         
    }
	
	@Test
    public void testEdit() throws Exception {
    	Integer pageId = 1;
        mockMvc.perform(get("/admin/page/edit/"+pageId))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("entityForm"))
          /*  .andExpect(model().attribute("MyObjectForm",
            		   hasProperty("myObjects",
            		       hasItem(hasProperty("myPropert", Matchers.equalTo(true))))))*/
            .andExpect(model().attribute("entityForm", hasProperty("title",is("page title 1")) ))
            .andExpect(model().attribute("entityForm", hasProperty("content",is("<p>page content 1</p>")) ))

            .andExpect(view().name("admin/module/page/edit"))
            .andExpect(content().string(containsString("/admin/page/update/"+pageId)));
;
    }
	
	@Test
    public void testEditNotFound() throws Exception {
    	Integer pageId = 100;
        mockMvc.perform(get("/admin/page/edit/"+pageId))
            .andExpect(status().isNotFound())
            .andExpect(view().name("error/404"));
;
    }
	
	@Test
    public void testUpdateSuccess() throws Exception {
		
		pageBefore = new Page("title page before", "content page before");
		pageRepository.save(pageBefore);
				
		Integer pageId = 100;
		RequestBuilder request = post("/admin/page/update/"+pageBefore.getId())
				.param("id", pageBefore.getId().toString())
	            .param("title", "page title test edited")
	            .param("content", "page content test edited")
	            .with(csrf());
		
		mockMvc.perform(request)
	            .andExpect(status().is3xxRedirection())
	            .andExpect(MockMvcResultMatchers.flash().attribute("message", "Successfully updated!"));
		
		
	//	Page pageAfter = pageRepository.findOne(100);
		Page pageAfter = pageRepository.findById(pageBefore.getId());
		assertEquals("page title test edited", pageAfter.getTitle());
		assertEquals("page content test edited", pageAfter.getContent());

		
		pageRepository.delete(pageBefore.getId());
		
		
	       //     .andExpect(model().attribute("entityForm", hasProperty("title",is("page title 1")) ))

	         /*   .andExpect(content().string(containsString("page title 2 edited")))*/;
		
		/*
        mockMvc.perform(post("/admin/page/update/"+pageId)
        		
        	.param("id", pageId.toString())
            .param("title", "page title 1 edited")
            .param("content", "page content 1 edited")
            .with(csrf())
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(MockMvcResultMatchers.flash().attribute("message", "Successfully updated!"))
            .andExpect(content().string(containsString("page title 1 edited")));
         */
    }
	
	@Test
    public void testUpdateWithError() throws Exception {
		Integer pageId = 2;
		RequestBuilder request = post("/admin/page/update/"+pageId)
				.param("id", pageId.toString())
	            .param("title", "")
	            .param("content", "")
	            .with(csrf());
		
		mockMvc.perform(request)
		.andExpect(model().attributeHasFieldErrors("entityForm", "title"))
		.andExpect(model().attributeHasFieldErrors("entityForm", "content"))
        .andExpect(status().isOk())
        .andExpect(view().name("admin/module/page/edit"));

	}
	
	@Test
    public void testDelete() throws Exception {
		pageBefore = new Page("title page before", "content page before");
		pageRepository.save(pageBefore);
		
		mockMvc.perform(post("/admin/page/delete/"+pageBefore.getId())
	            .with(csrf())
	        )
	            .andExpect(status().is3xxRedirection())
	            .andExpect(MockMvcResultMatchers.flash().attribute("message", "Successfully deleted!"));
		
		assertNull(pageRepository.findById(pageBefore.getId()));
		
		// clean
	//	pageRepository.delete(pageBefore.getId());
	         

	}
}
