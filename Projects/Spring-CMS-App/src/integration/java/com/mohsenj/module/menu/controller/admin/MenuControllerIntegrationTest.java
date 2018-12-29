package com.mohsenj.module.menu.controller.admin;

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


public class MenuControllerIntegrationTest extends BaseIntegrationTest {

	private static final int TEST_MENU_ID = 1;

	
	
	

   // private WebDriver driver;
/*
    @Mock
    private MenuService menuService;
    @Autowired
    private CategoryService categoryService;
    */

    
    private Menu menu_1;

    @Before
    public void setup() {
    	
    /*	this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(new WebSecurityConfig())
                .build();
    	*/
    	//   mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    	  
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
        mockMvc.perform(get("/admin/menu/index"))
           .andExpect(status().isOk())
          .andExpect(model().attributeExists("rootMenus"))
            .andExpect(view().name("admin/module/menu/index"));
     //   .andExpect(redirectedUrl());
      //  .andExpect(content().string("Honda Civic"));


    }
    
    @Test
    public void testCreate() throws Exception {
    	Integer parentId = 1;
        mockMvc.perform(get("/admin/menu/create/"+parentId))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("data"))
            .andExpect(model().attributeExists("entityForm"))
            .andExpect(view().name("admin/module/menu/create"));
    }
    
    @Test
    public void create_menuWithGivenParentIdNotExist_redirectToErrorPage() throws Exception {
    	Integer parentId = 10000; // this is big and menu will not be found
    	
        mockMvc.perform(get("/admin/menu/create/"+parentId))
            .andExpect(status().isBadRequest())
            .andExpect(view().name("error/error"))
            .andExpect(model().attributeExists("errorMsg"))
            
;
    }
  /*  
    @Test
    public void create_hasParentIdInModel() throws Exception {
    	Integer parentId = 1; 
    	
        mockMvc.perform(get("/admin/menu/create/"+parentId))
            .andExpect(status().isOk())
      
            .andExpect(model().attribute("entityForm",
            		   hasProperty("parentId",
            				   Matchers.equalTo(1))))
            
;
    }
    */
    
    @Test
    public void testCreateWithoutParentId_notFound() throws Exception {
    	//Integer parentId = 1;
        mockMvc.perform(get("/admin/menu/create/"))
            .andExpect(status().isNotFound());
          /*  .andExpect(model().attributeExists("data"))
            .andExpect(model().attributeExists("entityForm"))
            .andExpect(view().name("admin/module/menu/create"));*/
    }
    
    @Test
    public void testProcessCreationSuccess() throws Exception {
        mockMvc.perform(post("/admin/menu/store")
        			
            .param("title", "Joe")
            .param("ordering", "1")
            .param("parentId", "")
            .param("itemType", "content_list_khabar")
            .param("content_list_khabar", "1")
            .with(csrf())

 
        )
            .andExpect(status().is3xxRedirection())
            //.andExpect(content().string("Honda Civic"));
            .andDo(print());
    }
    
    @Test
    public void edit_test() throws Exception {
        mockMvc.perform(get("/admin/menu/edit/1")
        )
            .andExpect(status().isOk())
            //.andExpect(content().string("Honda Civic"));
          //  .andDo(print())
            ;
    }
    
}