package br.com.daniel.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.daniel.core.BaseTest;
import br.com.daniel.page.AlertaPage;
import br.com.daniel.page.Menupage;


public class AlertTest extends BaseTest {
	private Menupage menu = new Menupage();
	private AlertaPage alerta = new AlertaPage();
	@Test 
	public void deveConfirmarAlerta(){
		//acessar menu alerta
		menu.Alerta();
		alerta.gerarScreenshot("Alerta");
		//clicar em alerta confirm
		alerta.clickAlertaConfirm();
		alerta.gerarScreenshot("ClickAlerta");
		//verificar os textos
		Assert.assertEquals("Info", alerta.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());
		alerta.gerarScreenshot("ModalAlerta");
		//confirmar alerta
		alerta.confirmar();
		//verificar nova mensagem
		Assert.assertEquals("Info", alerta.obterTituloAlerta());
		Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());
		alerta.gerarScreenshot("ModalAlerta2");
		//sair
		alerta.infoSair();
		alerta.gerarScreenshot("Sair");
	}

}
