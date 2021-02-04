package com.jacaranda.personaje;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rpgame.security.controller.UserCRUDController;
import com.rpgame.security.model.dto.UserDto;
import com.rpgame.security.service.UserService;


//@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserCRUDController.class)
public class UserMVCTest {

@Autowired
private MockMvc mockMVC; // We use only the web layer, no server, no full context	

@MockBean
private UserService uService;

private final static String ROOT_PATH = "/user";

//@BeforeAll
//private void init() {
//	uService = Mockito.mock(UserService.class);
//}

@Test
public void getUserByIdReturnsIsOk() throws Exception{
	Mockito.when(uService.readUser(Mockito.anyLong()))
			.thenReturn(Mockito.mock(UserDto.class))
			.thenReturn(null);
	
	mockMVC.perform(get(ROOT_PATH+"/3")).andExpect(status().isOk());
	mockMVC.perform(get(ROOT_PATH+"/3")).andExpect(status().isNotFound());
}
}
