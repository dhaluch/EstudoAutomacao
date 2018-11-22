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

public class AbasPage extends BasePage {
	@Rule
	public TestName testName = new TestName();

	public void clickAba1() {
		clicarPorTexto("ABA 1");
		
	}
    
	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}

	public void clickAba2() {
		clicarPorTexto("ABA 2");
	}

	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}

	public void gerarScreenshot(String nome) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					new File("target/Screenshots/Abas/" + "Abas" + testName.getMethodName() + nome + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
