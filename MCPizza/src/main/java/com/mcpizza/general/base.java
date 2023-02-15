/* Copyright (c) 2022, arath MVA.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * 
 */
package com.mcpizza.general;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mcpizza.lib.WebActions;

/**
 * @author Adithya Ram
 *
 */
@org.testng.annotations.Listeners(com.mcpizza.lib.ItestListner.class)
public class base {
	
	public static WebDriver driver;
	

	@BeforeClass(alwaysRun = true)
	public void setup() {
		WebActions.print(">>>>>>>>>>>>>> Intiating the browser <<<<<<<<<<<<<<<<<<<<");
		String browser = WebActions.init_properties("browser").toLowerCase();

		if(browser.equals("chrome"))
		{
		driver = new ChromeDriver();

		}else if(browser.equals("firefox"))
		{

		driver = new FirefoxDriver();

		}
		else
		{
		System.out.println("Please provide a proper browser value..");
		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(WebActions.init_properties("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebActions.print("Intiated the browser");

		}
	public base() {

		PageFactory.initElements(driver, this);
	}
	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
			WebActions.print("Closed browser session");

		}
		
	}


		
	}
	


