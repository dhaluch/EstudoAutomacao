package br.com.daniel.page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.daniel.core.BasePage;
import br.com.daniel.core.DriverFactory;

public class AlertaPage extends BasePage {
	@Rule
	public TestName testName = new TestName();
	public void clickAlertaConfirm(){
		clicarPorTexto("ALERTA CONFIRM");
	}
	public void confirmar(){
		clicarPorTexto("Confirmar");
	}
	public void infoSair(){
		clicarPorTexto("Sair");
	}
	public String obterTituloAlerta(){
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagemAlerta(){
		return obterTexto(By.id("android:id/message"));
	}
	public void gerarScreenshot(String nome) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		//String time = DriverFactory.getDriver().manage().timeouts().toString();
		
		try {
			FileUtils.copyFile(imagem, new File("target/Screenshots/Alertas/" + testName.getMethodName()+ nome + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
