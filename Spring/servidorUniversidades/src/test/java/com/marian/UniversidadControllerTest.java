package com.marian;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.marian.controller.UniversidadController;
import com.marian.dto.Universidad;
import com.marian.repository.UniversidadRepository;

@SpringBootTest
public class UniversidadControllerTest {

	@InjectMocks
	private UniversidadController controller;
	
	@Mock
	private UniversidadRepository repo;
	
	
	/*
	 * Mockeamos que el repositorio devuelva una universidad y esperamos que la respuesta
	 * del controlador tenga esa universidad
	 */
	@Test
	public void verboGetTest1() {
		final List<Universidad> listaUniversidades = new ArrayList<>();
		final Universidad uni1 = new Universidad(1, "URJC3", "Mostoles", null);
		listaUniversidades.add(uni1);
		when(repo.getUniversidades()).thenReturn(listaUniversidades);
		
		Assertions.assertEquals(uni1, controller.getUniversidades().getBody().get(0));
	}
	
	/*
	 * Mockeamos que el repositorio no devuelva universidad y esperamos que la respuesta
	 * del controlador no tenga universidades
	 */
	@Test
	public void verboGetTest2() {
		final List<Universidad> listaUniversidades = new ArrayList<>();
		when(repo.getUniversidades()).thenReturn(listaUniversidades);
		
		Assertions.assertEquals(listaUniversidades.size(), controller.getUniversidades().getBody().size());
	}
	
	/*
	 * comprobando que el estado http es created
	 * 
	 */
	@Test
	public void verboPost1() throws Exception {
		final Universidad uni1 = new Universidad(1, "URJC3", "Mostoles", null);
		Assertions.assertEquals(HttpStatus.CREATED, controller.createUniversidad(uni1).getStatusCode());
	}
	
	
	/*
	 * que si univerdad es null tienes estado http de peticion erronea .
	 * 
	 */
	@Test
	public void verboPost2() throws Exception {
		final Universidad u = new Universidad(1,null,null,null);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, controller.createUniversidad(u).getStatusCode());
		
	}
	@Test 
	public void verboDelete1() throws Exception {
		when(repo.deleteUniversidad(0)).thenReturn(true);
		Assertions.assertEquals(HttpStatus.OK, controller.deleteUniversidad(0).getStatusCode());
	}
	@Test 
	public void verboDelete2() throws Exception {
		when(repo.deleteUniversidad(0)).thenReturn(false);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, controller.deleteUniversidad(0).getStatusCode());
	}

	
	
}
