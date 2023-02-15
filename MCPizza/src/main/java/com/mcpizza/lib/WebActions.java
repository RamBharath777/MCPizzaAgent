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
package com.mcpizza.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.mcpizza.general.base;
import com.mcpizza.general.pageFactorObjectIntilizer;

/**
 * @author Adithya Ram
 *
 */
public class WebActions extends pageFactorObjectIntilizer {

	static Properties prop;

	public static String init_properties(String key)
	{
	prop = new Properties();
	try {
	FileInputStream ip = new FileInputStream(new File("src/main/java/com/mcpizza/config/config.properties").getAbsolutePath());
	prop.load(ip);
	
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}catch (IOException e)
	{
	e.printStackTrace();
	}

	return prop.getProperty(key);


	}	
	public static void print(Object obj) {
		System.out.println(obj);
		Reporter.log(obj.toString());
	}
	
	public static  void waitForVisibility(WebElement element) throws Error{
		print("Wait until element is visable");
		//Thread.sleep(2000);
        new WebDriverWait(driver,  Duration.ofSeconds(60))
        .until(ExpectedConditions.visibilityOf(element));
	}

	public static  void waitForclickable(WebElement element) throws Error{
		print("Wait until element is clickble");
		//Thread.sleep(2000);
        new WebDriverWait(base.driver,  Duration.ofSeconds(60))
        .until(ExpectedConditions.elementToBeClickable(element));
	}
	public static  void switchToFrames(String NmaeOrId) {
		
		driver.switchTo().frame(NmaeOrId);
	
		
	}
	public static  void click(WebElement we) throws InterruptedException, Error {
	waitForclickable(we);
	Actions action =new Actions(driver);
	action.moveToElement(we).click().build().perform();
	}


}
