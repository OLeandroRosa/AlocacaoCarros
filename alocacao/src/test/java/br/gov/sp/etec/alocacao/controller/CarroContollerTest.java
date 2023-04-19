package br.gov.sp.etec.alocacao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.gov.sp.etec.alocacao.model.Carro;
import br.gov.sp.etec.alocacao.repository.CarroRepository;

@ExtendWith(SpringExtension.class)
public class CarroContollerTest {
	
	@InjectMocks
	CarroController controller;
	 
	@Mock
	CarroRepository reposity;
	
	@Mock 
	List<Carro> listaCarros;
	
	@Mock
	Carro carro;
	
	@Test
	public void carrosTesteComListaDeCarros() {
		when(reposity.findAll()).thenReturn(listaCarros);
		 List<Carro> carros = controller.carros();
		 assertNotNull(carros);
	}
	
	
	@Test
	public void carrosTesteNull() {
		when(reposity.findAll()).thenReturn(null);
		 List<Carro> carros = controller.carros();
		 assertNull(carros);
	}
	
	
	@Test
	public void AdicionarCarroComTesteSucesso() {
		when(reposity.save(any(Carro.class))).thenReturn(getCarro());
		Carro c = controller.updateCarro(new Carro("branco","12345", 1234L, "HB20"));
		assertEquals("fusca", c.getModelo());
		assertEquals("branco", c.getCor());
		assertEquals(1234L, c.getChassi());
		assertEquals(1234L, c.getPlaca());
		assertEquals(1L, c.getId());
		
	}
	
	@Test
	public void atualizarCarroComTesteSucesso() {
		when(reposity.save(any(Carro.class))).thenReturn(getCarro());
		Carro c = controller.updateCarro(getCarro());
		assertEquals("fusca", c.getModelo());
	
	}
	
	@Test
	public void deletarCarroComTesteSucesso() {
		//when(reposity.save(anyLong(Carro.class))).thenReturn(getCarro());
		controller.deleteCarro(1L);
		//assertNull(null);
	}
	
	private Carro getCarro() {
		Carro carro = new Carro();
		carro.setId(1L);
		carro.setModelo("fusca");
		carro.setCor("Branco");
		carro.setPlaca("1234");
		carro.setChassi(1234L);
		return carro;
	}
	
	

}
