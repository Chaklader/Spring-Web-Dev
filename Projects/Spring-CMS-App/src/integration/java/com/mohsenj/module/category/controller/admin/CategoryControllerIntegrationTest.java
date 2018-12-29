package com.mohsenj.module.category.controller.admin;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import com.mohsenj.BaseIntegrationTest;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.menu.model.Menu;



/**
 * Test class for {@link MenuController}
 *
 * @author Mohsen Jahanshahi
 */


public class CategoryControllerIntegrationTest extends BaseIntegrationTest{

	private static final int TEST_MENU_ID = 1;
    private Menu menu_1;

    @Before
    public void setup() {
    	menu_1 = new Menu();
        menu_1.setId(TEST_MENU_ID);
        menu_1.setTitle("test titel");

        Category category = new Category();
        category.setSlug("cat-slug");
    //    given(this.menuService.findRootMenusOrdeingDesc()).willReturn(Arrays.asList(menu_1));
       // when(this.menuService.findRootMenusOrdeingDesc()).thenReturn(Arrays.asList(menu_1));

     //   when(this.categoryService.findById(1)).thenReturn(category);
    }
    
    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/admin/category/index"))
           .andExpect(status().isOk())
          .andExpect(model().attributeExists("entities"))
            .andExpect(view().name("admin/module/category/index"));
     //   .andExpect(redirectedUrl());
      //  .andExpect(content().string("Honda Civic"));


    }
    
    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(get("/admin/category/create"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("entities"))
            .andExpect(model().attributeExists("selectOptions"))
            .andExpect(view().name("admin/module/category/create"));
    }
    
    @Test
    public void testProcessCreationSuccess() throws Exception {
        mockMvc.perform(post("/admin/category/store")
        			
            .param("name", "name")
            .param("parentId", "")
            .param("module", "1")
            .with(csrf())

 
        )
            .andExpect(status().is3xxRedirection())
            //.andExpect(content().string("Honda Civic"));
            .andDo(print());
    }
    
    @Test
    public void testProcessCreationHasErrors() throws Exception {
        mockMvc.perform(post("/admin/category/store")
        			
            .param("name", "")
            .param("parentId", "")
            .param("module", "1")
            .with(csrf())
 
        )
        .andExpect(status().isOk())
        .andExpect(model().attributeHasErrors("entityForm"))
        .andExpect(model().attributeHasFieldErrors("entityForm", "name"))
        .andExpect(view().name("admin/module/category/create"));
    }
    
}

