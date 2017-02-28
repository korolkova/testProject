package ru.test.jotter;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ru.test.jotter.controller.UserController;
import ru.test.jotter.model.User;
import ru.test.jotter.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
//@ComponentScan
@ContextConfiguration(classes=UserController.class)
public class UserControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private UserRepository userRepository;
    
	private List<User> userList = new ArrayList<User>();
	
	private User firstUser;
	
	private User secondUser;
	
	
	@Before
    public void setup() throws Exception {
		
        firstUser = new User(1L, "TestName1", "TestEmail1");
        secondUser = new User(2L, "TestName2", "TestEmail2");
        
        userList.add(firstUser);
        userList.add(secondUser);
        
		when(userRepository.findAll()).thenReturn(userList);	
    }
			
	@Test
    public void findAll() throws Exception {

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("TestName1")))
                .andExpect(jsonPath("$[0].email", is("TestEmail1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("TestName2")))
                .andExpect(jsonPath("$[1].email", is("TestEmail2")));
        
        
 
        /*verify(userRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository);*/
	}	
}

