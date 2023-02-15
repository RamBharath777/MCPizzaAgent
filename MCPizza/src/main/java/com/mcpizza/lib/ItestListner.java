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
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import com.mcpizza.general.base;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
/**
 * @author Adithya Ram
 *
 */
public class ItestListner implements ITestListener {


	public void onTestStart(ITestResult result) {
		
		System.out.println("New Test Started" +result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Successfully Finished" +result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed" +result.getName());
		DateFormat dateFormat = new SimpleDateFormat("-yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();


		String fileName= result.getTestClass().getName();//String fileName= t.getMethod().getMethodName();

		File filepath1 = new File ("Screenshots");

		String imgpath=filepath1.getAbsolutePath();
		File dstFile= new File(imgpath+"/"+fileName+ dateFormat.format(date)+".png");
	    
		try {
		base.driver = new org.openqa.selenium.remote.Augmenter().augment(base.driver );
			
		//Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(100000)).takeScreenshot(augmentedDriver);
			Screenshot screenshot = new AShot()
					.coordsProvider(new WebDriverCoordsProvider())
					.imageCropper(new IndentCropper() // overwriting cropper
					.addIndentFilter(new BlurFilter()))
					.takeScreenshot(base.driver);			
			ImageIO.write(screenshot.getImage(), "PNG", dstFile);
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Reporter.log(
					"<a title= \"title\" href=\"/"+dstFile+"\">" +
							"<img width=\"418\" height=\"240\" alt=\"alternativeName\" title=\"title\" src=\"/"+dstFile+"\"></a>");
			WebActions.print("Placed screen shot at :" + dstFile);
		} catch (IOException e1) {
			WebActions.print("Screenshot file not found :" +e1);
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped" +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Test Failed but within success percentage" +result.getName());
		
	}

	public void onStart(ITestContext context) {
		
		
		System.out.println("This is onStart method" +context.getOutputDirectory());
		
	}

	public void onFinish(ITestContext context) {
			
		System.out.println("This is onFinish method" +context.getPassedTests());
		System.out.println("This is onFinish method" +context.getFailedTests());
	}
}
