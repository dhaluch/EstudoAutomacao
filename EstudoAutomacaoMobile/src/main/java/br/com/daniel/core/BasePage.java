package br.com.daniel.core;

import static br.com.daniel.core.DriverFactory.getDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;

import io.appium.java_client.MobileElement;


public class BasePage {
	// private DSL dsl = new DSL();
	// Set

	public void escrever(By by, String texto) {
		try {
			getDriver().findElement(by).sendKeys(texto);
		} catch (Exception e) {

		}

	}

	public String obterTexto(By by) {
		String texto = null;
		try{
		  texto = getDriver().findElement(by).getText();
		}catch(Exception e){
			
		}
		return texto;
	}

	public void clickFormulario(By by) {
		getDriver().findElement(by).click();

	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));

	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void salvar(By by) {
		getDriver().findElement(by).click();
	}

	public Timeouts espera() {
		return getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}

	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;

	}

	public void setTexto(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
}
