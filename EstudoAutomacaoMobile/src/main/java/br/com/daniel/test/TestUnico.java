package br.com.daniel.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.daniel.core.BaseTest;
import br.com.daniel.core.DriverFactory;
import br.com.daniel.page.FormularioPage;
import br.com.daniel.page.Menupage;

public class TestUnico extends BaseTest {

	private Menupage menupage = new Menupage();
	private FormularioPage formulariopage = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		menupage.acessarFormulario();
		formulariopage.gerarScreenshot("ClickFormulario");
	}

	// Começo dos testes.
	@Test
	public void demonstracaoNavegacao() throws MalformedURLException {

		formulariopage.escreverNome("Chunda");

		// checar nome escrito
		Assert.assertEquals("Chunda", formulariopage.obterNome());

	}

	@Test

	public void Combo() throws MalformedURLException {
		// click no comboBox
		formulariopage.selecionarCombo("PS4");
		// selecionar dispositivo
		assertEquals("PS4", formulariopage.obterValorCombo());

	}

	@Test
	public void InteragirSwitchCheckbox() throws MalformedURLException {
		Assert.assertFalse(formulariopage.isCheckMarcado());
		Assert.assertTrue(formulariopage.isSwitchMarcado());

		formulariopage.clicarCheck();
		formulariopage.clicarSwitch();

		Assert.assertTrue(formulariopage.isCheckMarcado());
		Assert.assertFalse(formulariopage.isSwitchMarcado());

	}

	@Test

	public void Desafio() throws MalformedURLException {

		formulariopage.escreverNome("daniel");
		formulariopage.gerarScreenshot("escreverNome");

		formulariopage.selecionarCombo("PS4");
		formulariopage.gerarScreenshot("selecionarCombo");
		formulariopage.clicarCheck();
		formulariopage.gerarScreenshot("clickCheck");
		formulariopage.clicarSwitch();
		formulariopage.gerarScreenshot("clicarswitch");
		formulariopage.salvar();
		formulariopage.gerarScreenshot("salvar");
		// Validações

		Assert.assertEquals("Nome: daniel", formulariopage.obterNomeCadastro());
		System.out.println(formulariopage.obterNomeCadastro());

		Assert.assertEquals("Console: ps4", formulariopage.obterConsole());

		System.out.println(formulariopage.obterConsole());
		Assert.assertEquals("Switch: Off", formulariopage.obterSwitch());

		System.out.println(formulariopage.obterSwitch());
		Assert.assertEquals("Checkbox: Marcado", formulariopage.obterCheckbox());
		formulariopage.gerarScreenshot("validação indormações");
		System.out.println(formulariopage.obterCheckbox());

	}

	@Test
	public void realizarCadastroDemorado() throws MalformedURLException {

		formulariopage.escreverNome("daniel");
		formulariopage.salvarDemorado();

		// Validações

		Assert.assertEquals("Nome: daniel", formulariopage.obterNomeCadastro());
		System.out.println(formulariopage.obterNomeCadastro());

	}

	@Test
	public void alterarData() throws MalformedURLException {

		formulariopage.clicarPorTexto("01/01/2000");
		formulariopage.clicarPorTexto("20");
		formulariopage.clicarPorTexto("OK");
		Assert.assertTrue(formulariopage.existeElementoPorTexto("20/2/2000"));
	}
}
