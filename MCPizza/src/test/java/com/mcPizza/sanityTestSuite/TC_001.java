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
package com.mcPizza.sanityTestSuite;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.mcpizza.general.pageFactorObjectIntilizer;
import com.mcpizza.pages.chatPage;
import com.mcpizza.pages.homePage;
import com.mcpizza.pages.loginPage;

/**
 * @author Adithya Ram
 *
 */
public class TC_001 extends pageFactorObjectIntilizer {
	
	@Test
	public void demo_TestCase() throws InterruptedException {
		
		homePage.click_botAvatar();
		homePage.click_getStarted();
		loginPage.loginWithnewUser(RandomStringUtils.randomAlphanumeric(5).toLowerCase(), RandomStringUtils.randomAlphanumeric(5).toLowerCase()+"@ymail.com");
		chatPage.validateLastReplyFromBot("Welcome to McPizza Booking Journey");
		chatPage.typeMessageAndSend("I want to order a pizza");
		chatPage.selectVeg();
		chatPage.selectcheeseCheckboxAndSubmit();
		chatPage.selectThickCrust();
		chatPage.selectSmallSize();
		chatPage.confirmOrderYes();
		chatPage.validateLastReplyFromBot("CONGRATS ! ORDER PLACED .");
		chatPage.givethumbsUpFeedback(); 
		chatPage.submitFeedback();
		chatPage.validatefeedbackThankYouMessage("Thank You for Your Support");
	}

}
