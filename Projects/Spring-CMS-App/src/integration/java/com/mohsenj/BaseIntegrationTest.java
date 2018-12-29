package com.mohsenj;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mohsenj.config.PersistenceJPAConfigForTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringCms1Application.class, PersistenceJPAConfigForTest.class})
@TestPropertySource(locations="classpath:application-test.properties")
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {

	@Autowired
    protected FilterChainProxy springSecurityFilterChain;
	
	@Autowired
	protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	
	@Before
    public void basesetup() {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilters(this.springSecurityFilterChain).build();
	}
	
}
