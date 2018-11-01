package br.com.daniel.secao3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class aula12 {
	@Test
	public void demonstracaoNavegacao() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "SM-J500M");
	    desiredCapabilities.setCapability("automator", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.ctappium");
	    desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
	    desiredCapabilities.setCapability("noReset", "true");
	    AndroidDriver<MobileElement> driver =  new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //Selecionar Formulario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    /*for(MobileElement elemento: elementosEncontrados ){
    		System.out.println(elemento.getText());
    		}*/
	    elementosEncontrados.get(1).click();
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    //MobileElement 
	    campoNome.sendKeys("Daniel");
	    //checar nome escrito
	    String text = campoNome.getText();
	    
	    
	    Assert.assertEquals("Daniel", text);
	    driver.quit();
	}
}
