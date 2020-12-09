package com.jacaranda.personaje;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rpgame.entity.User;
import com.rpgame.rest.controllers.UserCRUDController;
import com.rpgame.service.UserService;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserCRUDController.class)
public class UserMVCTest {

@Autowired
private MockMvc mockMVC; // We use only the web layer, no server, no full context	

@MockBean
private  static UserService uService;

private final static String ROOT_PATH = "/user";

@BeforeAll
private static void init() {
	uService = Mockito.mock(UserService.class);
}

@Test
public void getUserByIdReturnsIsOk() throws Exception{
	Mockito.when(uService.readUser(Mockito.anyLong()))
			.thenReturn(Mockito.mock(User.class))
			.thenReturn(null);
	
	mockMVC.perform(get(ROOT_PATH+"/3")).andExpect(status().isOk());
	mockMVC.perform(get(ROOT_PATH+"/3")).andExpect(status().isNotFound());
}
}
