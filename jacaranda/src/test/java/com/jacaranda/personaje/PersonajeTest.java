package com.jacaranda.personaje;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
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
	private List<Personaje> mockedLista;
	
	
	@BeforeEach
	private void init() {
		sut = new PersonajeService();
		mockedUserRepo = mock(UserRepository.class);
		mockedUser = mock(User.class);
		mockedLista = mock(List.class);
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
	
	@ParameterizedTest
	@MethodSource("datos")
	public void testeo(Long idUsuario) {
		try {
			when(mockedUserRepo.findUserByIdUsuario(idUsuario)).thenReturn(mockedUser);
			when(mockedUser.getPersonajes()).thenReturn(mockedLista);
			when(sut.getPersonajeFromUser(idUsuario)).thenReturn(mockedLista);
			
		}catch(Exception e){
			throw new AssertionError(e.getMessage());
		}
	}
	
	private static Stream<Arguments> datos() {
	    return Stream.of(
	      Arguments.of(null, true),
	      Arguments.of(1, true),
	      Arguments.of("", true)
	    );
	}
	
	
	
	
	
	
	

}
