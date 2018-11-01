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

public class Aula16SwitchCheckbox {
	@Test
	public void InteragirSwitchCheckbox() throws MalformedURLException {
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
	     driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	    //Verificar estatos dos elementos
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	    //clicar nos elementos
	    check.click();
	    switc.click();
	    //Verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.quit();
	}
}
