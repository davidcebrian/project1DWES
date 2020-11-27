package com.jacaranda.personaje;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.rpgame.entity.Personaje;
import com.rpgame.entity.User;
import com.rpgame.repositorys.UserRepository;
import com.rpgame.service.PersonajeService;


public class PersonajeTest {
	
	//SUT
	private PersonajeService sut;
	
	//DEPENDENCIAS

	private UserRepository mockedUserRepo;
	private User mockedUser;
	private static List<Personaje> lista;
	
	
	@BeforeEach
	private void init() {
		mockedUserRepo = mock(UserRepository.class);
		mockedUser = mock(User.class);
		
		lista = new ArrayList<Personaje>();
		User us = new User("paco", "pacote", "paquirri", "66666666","asdf@es");
		Personaje uno = new Personaje(us, "uno", "cara1", "cuerpo1","pelo1","ropa1","tipo1", 10);
		Personaje dos = new Personaje(us, "dos", "cara2", "cuerpo2","pelo2","ropa2","tipo2", 20);
		lista.add(uno);
		lista.add(dos);
		sut = new PersonajeService(mockedUserRepo);
		
	}
	
	/** --METODO A TESTEAR-- 
	 	public List<Personaje> getPersonajeFromUser(Long idUser) throws Exception {
		User us = userRepository.findUserByIdUsuario(idUser);
		List<Personaje> pjs = null;
		if (us != null) {
			pjs = us.getPersonajes();
		} else {
			throw new Exception("El usuario no ha sido encontrado.");
		}
		return pjs;
	}
	 * **/
	@Test
	public void test() {
		
	}
	
	@ParameterizedTest
	@MethodSource("personajesFromUserData")
	public void getPersonajesFromUserTest(Long idUsuario, List<Personaje> expected) {
		
		try {
			when(mockedUserRepo.findUserByIdUsuario(idUsuario)).thenReturn(mockedUser);
			when(mockedUser.getPersonajes()).thenReturn(lista);
			sut.getPersonajeFromUser(idUsuario);
		
			
		}catch(Exception e){
			assert(idUsuario == null);
			assert(e.getMessage() == "El usuario no ha sido encontrado");
			// new AssertionError(e.getMessage());
		}
	}
	
	private static Stream<Arguments> personajesFromUserData() {
	    return Stream.of(
	      Arguments.of((long)1, lista),
	      Arguments.of(null, null)
	    );
	}
	
	
	
	
	
	
	

}
