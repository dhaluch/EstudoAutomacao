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
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

	@Rule
	public TestName testName = new TestName();

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));

	}

	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}

	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}

	public void salvar() {
		salvar(By.className("android.widget.Button"));
	}

	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}

	public String obterNomeCadastro() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Nome: daniel']"));

	}

	public String obterConsole() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Console: ps4']"));
	}

	public String obterSwitch() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Switch: Off']"));
	}

	public String obterCheckbox() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
	}

	public void gerarScreenshot(String nome) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		// String time =
		// DriverFactory.getDriver().manage().timeouts().toString();
		
		try {
			FileUtils.copyFile(imagem,
					new File("target/Screenshots/TestUnico/" +"Formulario"+ testName.getMethodName() + nome + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
