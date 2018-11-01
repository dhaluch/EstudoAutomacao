package br.com.daniel.page;

import br.com.daniel.core.BasePage;

public class Menupage extends BasePage {

	public void acessarFormulario() {
		
		clicarPorTexto("Formulário");
	}
	public void splash(){
		clicarPorTexto("Splash");
	}
	public void Alerta(){
		clicarPorTexto("Alertas");
	}
	public void acessarAbas(){
		clicarPorTexto("Abas");
	}
	public void acordion(){
		clicarPorTexto("Accordion");
	}
}
