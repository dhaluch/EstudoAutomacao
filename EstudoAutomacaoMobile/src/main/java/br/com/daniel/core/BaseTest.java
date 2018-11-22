package br.com.daniel.core;

import org.junit.After;
import org.junit.AfterClass;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTest {
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	@Rule
	public TestName testName = new TestName();

	@AfterClass
	public static void FinalizaClasse() {
		DriverFactory.killDriver();
	}

	@After
	public void FinalizarApp() {
		// gerarScreenshot();
		DriverFactory.getDriver().resetApp();
	}

	public void esperaPresence(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

}
