package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

public class UC01RegistrarEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*
	 * Verifica o comportamento da classe servico metodo empresta
	 */
	@Test
	public void CT01UC01FB_registra_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}

	/*
	 * Verifica o comportamento da classe servico metodo empresta
	 */
	@Test(expected = RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		servico.empresta(null, usuario);
	}
	
	/*
	 * Verifica o comportamento da classe servico metodo empresta
	 */
	@Ignore
	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos() {
		try {
			servico.empresta(null, usuario);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}
	@Test
	public void CT04_verifica_isbn() {
		assertEquals("121212",livro.getIsbn());
	}
	
	
}