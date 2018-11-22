package br.com.daniel.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	static ExtentReports report;
	static ExtentTest test;
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass
	public static void statusReport(String name){
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtetnReportResults.html");
		test = report.startTest(name);
	}
	
	
	@AfterClass
	public static void FinalizaClasse() {
		report.endTest(test);
		report.flush();
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
