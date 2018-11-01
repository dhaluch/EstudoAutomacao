package br.com.daniel.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.daniel.core.BaseTest;
import br.com.daniel.page.AcordionPage;
import br.com.daniel.page.Menupage;

public class AcordionTest extends BaseTest {
	
	private Menupage menu = new Menupage();
	private AcordionPage acordion = new AcordionPage();
	@Test
	private void interagirAcordin(){
		menu.acordion();
		//clicar em opção 1
		acordion.clicarOpcao1();
		//verifica mensagem da opção 1
		Assert.assertTrue(acordion.verificaMensagemopcao1());
		//clicar em opção em 2
		acordion.clicarOpcao2();
		//verificar mensagem opção 2
		Assert.assertTrue(acordion.verificarMensagemOpcao2());
		//clicar em opção 1
		
		//verifica se a mensagem 1 sumiu
		//clicar em opção 2
		//verificar se a mesangem opção 2 sumiu
	}
}
