package br.com.daniel.page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.daniel.core.BasePage;
import br.com.daniel.core.DriverFactory;

public class AcordionPage extends BasePage {
	@Rule
	public TestName testName = new TestName();

	public void clicarOpcao1() {
		clicarPorTexto("Opção 1");
	}

	public void clicarOpcao2() {
		clicarPorTexto("Opção 1");
	}

	public boolean verificaMensagemopcao1() {
		return existeElementoPorTexto("Esta é a descrição da opção 1");
	}

	public boolean verificarMensagemOpcao2() {
		return existeElementoPorTexto("Esta é a descrição da opção 2");
	}

	public void gerarScreenshot(String nome) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		// String time =
		// DriverFactory.getDriver().manage().timeouts().toString();

		try {
			FileUtils.copyFile(imagem,
					new File("target/Screenshots/Acordion/" + "Acordion" + testName.getMethodName() + nome + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
