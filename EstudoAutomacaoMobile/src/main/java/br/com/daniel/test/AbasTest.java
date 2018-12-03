package br.com.daniel.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.daniel.core.BaseTest;
import br.com.daniel.page.AbasPage;
import br.com.daniel.page.Menupage;

public class AbasTest extends BaseTest {
	private Menupage menu = new Menupage();
	private AbasPage abas = new AbasPage();
	@Test
	public void deveInABA1teragirComAbas(){
		//acessar menu abas
		statusReport("Interação com Abas");
		esperaPresence(By.className("android.widget.TextView"));
		menu.acessarAbas();
		abas.gerarScreenshot("clickAbas");
		//verificar que esta na aba 1
		abas.isAba1();
		Assert.assertTrue(abas.isAba1());
		abas.gerarScreenshot("verifiaçãoAba1");
		//acessar aba 2
		abas.clickAba2();
		abas.gerarScreenshot("clickAba2");
		//veriifcar que esta na aba 2
		Assert.assertTrue(abas.isAba2());
		abas.gerarScreenshot("verificaAba2");
		System.out.print("teste de git");
		
	}

}
