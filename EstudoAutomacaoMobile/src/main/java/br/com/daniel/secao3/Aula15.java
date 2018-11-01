package br.com.daniel.secao3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Aula15 {
	@Test
	public void Combo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "SM-J500M");
		desiredCapabilities.setCapability("automator", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		desiredCapabilities.setCapability("noReset", "true");
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		// Selecionar Formulario
		 
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		// clicar no combo
		

		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// selecionar opcao desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		// verificar
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("PS4", text);
		driver.quit();
	}
}
