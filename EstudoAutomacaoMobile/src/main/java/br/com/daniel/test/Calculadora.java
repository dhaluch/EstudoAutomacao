package br.com.daniel.test;

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

public class Calculadora {
	@Test
	public void Soma() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "SM-J500M");
	    desiredCapabilities.setCapability("automator", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	    desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
	    desiredCapabilities.setCapability("noReset", "true");
	    AndroidDriver<MobileElement> driver =  new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Seleciona dois numeros e faz a soma
	    MobileElement SelecionaOito = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_08"));
	    SelecionaOito.click();
	    
	    MobileElement SomaButton = driver.findElement(MobileBy.AccessibilityId("Mais"));
	    SomaButton.click();
	    
	    MobileElement SelecionaSeis = driver.findElement(By.xpath("//android.widget.Button[@text=6]"));
	    SelecionaSeis.click();
	    
	    MobileElement igual = driver.findElement(MobileBy.AccessibilityId("Igual"));
	    igual.click();
	    
	    //Valida a soma
	    MobileElement validaResultado = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc"));
	    
	    String resultado = validaResultado.getText();
	    
	    Assert.assertEquals("14", resultado);
	    System.out.println("Resultado da Calculadora: " + resultado);
	    driver.quit();
	}

}
