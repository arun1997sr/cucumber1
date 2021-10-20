package com.telecome.stepdifinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddTariffPlansSteps {
	static WebDriver driver;
	@Given("user launchs demo telecome application")
	public void user_launchs_demo_telecome_application() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("http://www.demo.guru99.com/telecom/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Given("click on add tariff plans option")
	public void click_on_add_tariff_plans_option() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	   
	}

	@When("user enter all the requirements")
	public void user_enter_all_the_requirements() {
	    
		driver.findElement(By.id("rental1")).sendKeys("450");
		driver.findElement(By.id("local_minutes")).sendKeys("400");
		driver.findElement(By.id("inter_minutes")).sendKeys("350");
		driver.findElement(By.id("sms_pack")).sendKeys("100");
		driver.findElement(By.id("minutes_charges")).sendKeys("12");
		driver.findElement(By.id("inter_charges")).sendKeys("50");
		driver.findElement(By.id("sms_charges")).sendKeys("4");
		
		
	}

	@When("user click submit button")
	public void user_click_submit_button() {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
	}

	@Then("validate  you add Tariff Plan")
	public void validate_you_add_Tariff_Plan() {
		WebElement text = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']"));
		 String text2 = text.getText();
		 System.out.println(text2);
		 Assert.assertEquals("Congratulation you add Tariff Plan", text2);
	}
	@When("user enter all the requirements by using one dimension list")
	public void user_enter_all_the_requirements_by_using_one_dimension_list(io.cucumber.datatable.DataTable dataTable) {
		
		List<String> a = dataTable.asList(String.class);
		driver.findElement(By.id("rental1")).sendKeys(a.get(0));
		driver.findElement(By.id("local_minutes")).sendKeys(a.get(1));
		driver.findElement(By.id("inter_minutes")).sendKeys(a.get(2));
		driver.findElement(By.id("sms_pack")).sendKeys(a.get(3));
		driver.findElement(By.id("minutes_charges")).sendKeys(a.get(4));
		driver.findElement(By.id("inter_charges")).sendKeys(a.get(5));
		driver.findElement(By.id("sms_charges")).sendKeys(a.get(6));
	}
	
	@When("user enter all the requirements by using one dimensional map")
	public void user_enter_all_the_requirements_by_using_one_dimensional_map(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> a = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("rental1")).sendKeys(a.get("ren"));
		driver.findElement(By.id("local_minutes")).sendKeys(a.get("loc min"));
		driver.findElement(By.id("inter_minutes")).sendKeys(a.get("intern min"));
		driver.findElement(By.id("sms_pack")).sendKeys(a.get("sms pack"));
		driver.findElement(By.id("minutes_charges")).sendKeys(a.get("loc chg"));
		driver.findElement(By.id("inter_charges")).sendKeys(a.get("int chg"));
		driver.findElement(By.id("sms_charges")).sendKeys(a.get("sms cgh"));
	}






	

}
