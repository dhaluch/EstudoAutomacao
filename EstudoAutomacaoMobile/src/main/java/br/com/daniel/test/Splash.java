package br.com.daniel.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.daniel.core.BaseTest;
import br.com.daniel.page.Menupage;
import br.com.daniel.page.SplashPage;

public class Splash extends BaseTest {
	private Menupage menu  = new Menupage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir(){
		//acessar menu splash
		menu.splash();
		//verificar que o splash esta sendo exibido 
		splash.existeElementoPorTexto("Splash!");
		//aguardar a saida do splash
		splash.aguardarSplashSumir();
		//veriifcar que o formulario esta aparecendo
		Assert.assertTrue(splash.existeElementoPorTexto("Formulário"));
	}

}
