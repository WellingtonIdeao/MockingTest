package com.br.test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.br.exception.SaidaException;
import com.br.model.IWebService;


public class WebServiceTest {
	private IWebService webServiceMock;
	private String saida;
	
	@Before
	public void setUp() {
		webServiceMock = createMock(IWebService.class);
	}

	@Test
	public void testTipoSaida1() {
		
		expect(webServiceMock.read()).andReturn("1");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("1", saida);
		this.saida = "1 - Retorno";
		verify(webServiceMock);
	}
	
	@Test
	public void testTipoSaida2() {
		expect(webServiceMock.read()).andReturn("2");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("2", saida);
		this.saida = "2 - Retorno SADT";
		verify(webServiceMock);
	}
	
	@Test
	public void testTipoSaida3() {
		expect(webServiceMock.read()).andReturn("3");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("3", saida);
		this.saida = "3 - Refer�ncia";
		verify(webServiceMock);
	}
	
	@Test
	public void testTipoSaida4() {
		expect(webServiceMock.read()).andReturn("4");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("4", saida);
		this.saida = "4 - Interna��o";
		verify(webServiceMock);
	}
	
	@Test
	public void testTipoSaida5() {
		expect(webServiceMock.read()).andReturn("5");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("5", saida);
		this.saida = "5 - Alta";
		verify(webServiceMock);
	}
	
	@Test
	public void testTipoSaida6() {
		expect(webServiceMock.read()).andReturn("6");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("6", saida);
		this.saida = "6 - Obito";
		verify(webServiceMock);	
	}
	
	@Test
	public void testTipoInvalido() {
		expect(webServiceMock.read()).andReturn("7");
		replay(webServiceMock);
		this.saida = webServiceMock.read();
		assertEquals("7", saida);
		this.saida = "Tipo env�lido";
		verify(webServiceMock);	
	}
	
	@Test
	public void testTipoException() {
		expect(webServiceMock.read()).andThrow(new SaidaException("Formato inv�lido"));
		replay(webServiceMock);
		try{
			this.saida = webServiceMock.read();
			fail("sem excess�o");
		}catch(SaidaException e){
			assertEquals("Formato inv�lido",e.getMessage());
			this.saida = e.getMessage();
		}
		verify(webServiceMock);
	}
	
	@After
	public void mensagem(){
		System.out.println(saida);
	}
	
}
