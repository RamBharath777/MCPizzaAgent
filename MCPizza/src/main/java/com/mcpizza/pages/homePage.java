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
package com.mcpizza.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mcpizza.general.pageFactorObjectIntilizer;
import com.mcpizza.lib.WebActions;

/**
 * @author Adithya Ram
 *
 */
public class homePage extends pageFactorObjectIntilizer {

	@FindBy(xpath = "//a[@class='avm-bot-avatar']/img") 	
	private static WebElement bot_avatar;
	
	
	@FindBy(xpath = "//a[text()='Get Started']") 	
	private static WebElement get_Started;
	
	public static void click_botAvatar() throws InterruptedException, Error {
		WebActions.click(bot_avatar);
		WebActions.print("Clicked on bot avatar");
	}
	
	public static void click_getStarted() throws InterruptedException, Error {
		WebActions.waitForclickable(get_Started);
		get_Started.click();
		WebActions.print("Clicked on Get Started");
	}
}
