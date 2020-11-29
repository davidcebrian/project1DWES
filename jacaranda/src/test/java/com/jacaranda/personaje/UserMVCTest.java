package com.jacaranda.personaje;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;

import com.rpgame.entity.User;
import com.rpgame.rest.controllers.UserCRUDController;
import com.rpgame.service.UserService;

import javassist.NotFoundException;

//@MockBean(value = {AddressReprository.class, 
//		   DocumentRepository.class, 
//		   FileHandlerService.class
//		   })
@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserCRUDController.class) // This way we route the requests to be tested to this Controller
public class UserMVCTest {

@Autowired
private MockMvc mockMVC; // We use only the web layer, no server, no full context	

@MockBean
private  UserService uService;

private final static String ROOT_PATH = "/user";

@BeforeTestExecution
private void init() {
	
}

@Test
public void getUserByIdReturnsIsOk(){
	// We set the service behavior as this: first call throws an Exception; second call returns a new Customer
	ResponseEntity<?> response = uService.readUser(Mockito.anyLong());
	Mockito.when(uService.readUser(Mockito.anyLong()))
			.thenReturn()
			.thenReturn();
	
	mockMVC.perform(get(ROOT_PATH+"/3")).andExpect(status().isNotFound());
	mockMVC.perform(get(ROOT_PATH+"/3")).andExpect(status().isOk());
}
}
