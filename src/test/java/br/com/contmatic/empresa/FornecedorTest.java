package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;
import br.com.contmatic.telefone.TelefoneDDDType;
import br.com.contmatic.telefone.TipoTelefoneType;;

@FixMethodOrder(NAME_ASCENDING)
public class FornecedorTest {

	private String cnpj;

	private String nome;

	private Telefone telefone;

	private static Fornecedor fornecedor;
	
	private static Produto produto;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Iniciamos os testes na classe fornecedor");
	}

	@Before
	public void setUpProduto() {
		produto = new Produto(1, "placa mãe", 1, BigDecimal.valueOf(500.00));
	}
	
	@Before
	public void setUp() {
		cnpj = "97904702000131";
		nome = "CA peças LTDA";
		Set<Produto> produtos = new HashSet<>();
		produtos.add(produto);
		telefone = new Telefone(TelefoneDDDType.DDD11, "978457845", TipoTelefoneType.CELULAR);
		Endereco endereco = new Endereco("02708010", 21);
		fornecedor = new Fornecedor(cnpj, nome, telefone, produtos, endereco);
	}

	@Test
	public void deve_testar_se_o_cnpj_aceita_numeros() {
		fornecedor.setCnpj("35667373000103");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_null() {
		fornecedor.setCnpj(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_vazio() {
		fornecedor.setCnpj("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_espaco_em_branco() {
		fornecedor.setCnpj("  ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_letras() {
		fornecedor.setCnpj("abcdef");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_caracteres_especiais() {
		fornecedor.setCnpj("@#$");
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_espaco_no_inicio() {
		fornecedor.setCnpj(" 35667373000103");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_espaco_no_final() {
		fornecedor.setCnpj("35667373000103 ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_cnpj_aceita_muitos_espacos_entre_os_numeros() {
		fornecedor.setCnpj("3566737       3000103");
	}
	
	@Test
	public void deve_testar_o_getCnpj() {
		fornecedor.setCnpj("35667373000103");
		assertEquals(fornecedor.getCnpj(), ("35667373000103"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_exception_do_cnpj_tamanho_menor() {
		fornecedor.setCnpj("1313131313131");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_exception_do_cnpj_tamanho_maior() {
		fornecedor.setCnpj("1515151515151515");
	}
	
	@Test
	public void deve_testar_se_o_nome_aceita_letras() {
		fornecedor.setNome("Gabriel");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_null() {
		fornecedor.setNome(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_vazio() {
		fornecedor.setNome("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_espaco_em_branco() {
		fornecedor.setNome("          ");
	}
	
	@Test
	public void deve_testar_se_o_nome_aceita_numeros() {
		fornecedor.setNome("123456");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_caracteres_especiais() {
		fornecedor.setNome("@#$");
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_espaco_no_inicio() {
		fornecedor.setNome(" Gabriel");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_espaco_no_final() {
		fornecedor.setNome("Gabriel ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_se_o_nome_aceita_muitos_espacos_entre_as_palavras() {
		fornecedor.setNome("Gabriel         Bueno");
	}
	
	@Test
	public void deve_testar_se_o_nome_aceita_um_espaco_entre_as_palavras() {
		fornecedor.setNome("Gabriel Bueno");
	}
	
	@Test
	public void deve_testar_o_getNome() {
		fornecedor.setNome("Gabriel Bueno");
		assertEquals(fornecedor.getNome(), "Gabriel Bueno");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_exception_do_nome_tamanho_menor() {
		fornecedor.setNome("a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_testar_exception_do_nome_tamanho_maior() {
		fornecedor.setNome("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcaabcabcabcabcabcaabcabcabc"
				+ "abcabcaabcabcabcabcabcabcabcabcabcabcabxc");
	}
	
	@Test
	public void deve_testar_o_getTelefone() {
		fornecedor.getTelefone();
	}
	
	@Test
	public void deve_testar_o_getProduto() {
		fornecedor.getProduto();
	}
	
	@Test
	public void deve_testar_o_getEndereco() {
		fornecedor.getEndereco();
	}

	@Test
	public void deve_retornar_true_no_hashCode_com_fornecedor_iguais() {
		Fornecedor fornecedor2 = new Fornecedor("97904702000131", "CA peças LTDA");
		assertEquals(fornecedor.hashCode(), fornecedor2.hashCode());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_false_no_hashCode_com_uma_fornecedor_de_cnpj_null() {
		Fornecedor fornecedor2 = new Fornecedor(null, "CA peças LTDA");
		assertNotEquals(fornecedor.hashCode(), fornecedor2.hashCode());
	}

	@Test
	public void deve_retornar_true_no_equals_com_fornecedores_iguais() {
		Fornecedor fornecedor2 = new Fornecedor("97904702000131", "CA peças LTDA");
		assertEquals(fornecedor, fornecedor2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_false_no_equals_com_um_fornecedor_de_cnpj_null() {
		Fornecedor fornecedor2 = new Fornecedor(null, "CA peças LTDA");
		assertEquals(fornecedor, fornecedor2);
	}

	@Test
	public void deve_retornar_true_no_equals_comparando_um_fornecedor_com_ela_mesmo() {
		assertEquals(fornecedor, fornecedor);
	}

	@Test
	public void deve_retornar_false_no_equals_comparando_um_fornecedor_com_null() {
		assertNotEquals(fornecedor, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deve_retornar_true_no_equals_comparando_dois_fornecedores_de_cnpj_null() {
		Fornecedor fornecedor1 = new Fornecedor(null, "CA peças LTDA");
		Fornecedor fornecedor2 = new Fornecedor(null, "CA peças LTDA");
		assertEquals(fornecedor1, fornecedor2);
	}

	@Test
	public void deve_retornar_false_no_equals_com_fornecedores_de_cnpj_diferentes() {
		Fornecedor fornecedor1 = new Fornecedor("97904702000131", "CA peças LTDA");
		Fornecedor fornecedor2 = new Fornecedor("43202648000153", "CA peças LTDA");
		assertNotEquals(fornecedor2, fornecedor1);
	}

	@Test
	public void deve_retornar_false_no_equals_com_a_fornecedor_e_um_numero_aleatorio() {
		assertNotEquals(fornecedor, new Object());
	}
	
	@Test
	public void toString_deve_retornar_valores_preenchidos() {
		Fornecedor fornecedorPreenchido = new Fornecedor("97904702000131", "CA peças LTDA");
		String fornecedorPreenchidoToString = fornecedorPreenchido.toString();
		assertEquals(fornecedorPreenchido.toString(), fornecedorPreenchidoToString);
	}

	@After
	public void tearDown() {
		cnpj = null;
		nome = null;
		telefone = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println(fornecedor);
		System.out.println("Finalizamos os testes na classe funcionario\n");
	}

}