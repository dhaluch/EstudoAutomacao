package br.com.daniel.test;

import org.junit.Assert;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentTest;

import br.com.daniel.core.BaseTest;
import br.com.daniel.page.AcordionPage;
import br.com.daniel.page.Menupage;

public class AcordionTest extends BaseTest {
	
	private Menupage menu = new Menupage();
	private AcordionPage acordion = new AcordionPage();
	@Test
	private void interagirAcordin(){
		menu.acordion();
		//clicar em op��o 1
		acordion.clicarOpcao1();
		
		//verifica mensagem da op��o 1
		Assert.assertTrue(acordion.verificaMensagemopcao1());
		//clicar em op��o em 2
		acordion.clicarOpcao2();
		//verificar mensagem op��o 2
		Assert.assertTrue(acordion.verificarMensagemOpcao2());
		//clicar em op��o 1
		
		//verifica se a mensagem 1 sumiu
		//clicar em op��o 2
		//verificar se a mesangem op��o 2 sumiu
	}
}
