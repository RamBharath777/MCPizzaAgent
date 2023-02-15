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
import org.testng.Assert;

import com.mcpizza.general.pageFactorObjectIntilizer;
import com.mcpizza.lib.WebActions;

/**
 * @author Adithya Ram
 *
 */
public class chatPage extends pageFactorObjectIntilizer {
	
	
	@FindBy(xpath  = "//p[@class='desc text-content ']") 	
	private static WebElement welcomeMessage;
	
	@FindBy(name  = "message") 	
	private static WebElement typeMessage;
	
	
	@FindBy(xpath  = "//button[text()='Send']") 	
	private static WebElement send;
	
	@FindBy(xpath  = "//div[@class='conversation-item clearfix not-mine']//p") 	
	private static WebElement likeToOrder;
	
	
	@FindBy(xpath  = "//a[text()='veg']") 	
	private static WebElement selectVeg;
	
	
	//@FindBy(xpath  = "//input[@value='cheese_id']") 	
	@FindBy(xpath = "//span[text()='Cheese']")
	private static WebElement cheeseCheckbox;
	
	
	@FindBy(xpath  = "//button[@class='btn default_card_submit']") 	
	private static WebElement submit;
	
	
	@FindBy(xpath  = "(//a[@title='Thick Crust'])[1]") 	
	private static WebElement selectThickCrust;		
	
	
	@FindBy(xpath  = "//a[text()='Small']") 	
	private static WebElement selectSmallSize;	
	
	
	@FindBy(xpath  = "//a[text()='Yes']") 	
	private static WebElement confirmOrderYes;	
	
	
	@FindBy(xpath  = "(//p[@class='desc text-content '])[last()]") 	
	private static WebElement lastmessageFromBot;	
	
	
	@FindBy(xpath  = "//p[contains(text(),'Your Pizza Will Look like this')]") 	
	private static WebElement yourPizzaWillLooklikethis;	
	
	
	@FindBy(xpath  = "//button[@class='thumbs-up']") 	
	private static WebElement thumbsUp;	
	
	
	@FindBy(xpath  = "//input[@role='combobox']") 	
	private static WebElement feedbackPick;	
	
	
	@FindBy(xpath  = "//li[text()='Good']") 	
	private static WebElement feedbackGood;	
	
	
	@FindBy(xpath  = "(//button[text()='Submit'])[last()]") 	
	private static WebElement feedbackSubmit;	
	
	
	@FindBy(xpath  = "//div[@class='thankyou']") 	
	private static WebElement feedbackThankYouMessage;	
	
	public static void validateWelcomeMessage() {
		WebActions.waitForVisibility(welcomeMessage);
		Assert.assertTrue(welcomeMessage.isDisplayed());
		Assert.assertEquals(welcomeMessage.getText().trim(), "Welcome to McPizza Booking Journey");
		WebActions.print("Welcome message validated sucessfully");
	}
	
	public static void validateLastReplyFromBot(String expectedText ) throws InterruptedException {
		Thread.sleep(5000);
		WebActions.waitForVisibility(lastmessageFromBot);
		Assert.assertTrue(lastmessageFromBot.isDisplayed());
		Assert.assertEquals(lastmessageFromBot.getText().trim(), expectedText);
		WebActions.print("'"+expectedText+"' message validated sucessfully");
	}

	public static void validatefeedbackThankYouMessage(String expectedText ) {
		WebActions.waitForVisibility(feedbackThankYouMessage);
		Assert.assertTrue(feedbackThankYouMessage.isDisplayed());
		Assert.assertEquals(feedbackThankYouMessage.getText().trim(), expectedText);
		WebActions.print("'"+expectedText+"' message validated sucessfully");
	}

	public static void typeMessageAndSend(String message ) {
		
		WebActions.waitForVisibility(typeMessage);
		typeMessage.sendKeys(message);
		WebActions.waitForclickable(send);
		send.click();
		WebActions.print("Message "+message+" sent sucessfully");
	}
	
	public static void validateChatBotReplylikeToOrder() {
		WebActions.waitForVisibility(likeToOrder);
		Assert.assertTrue(likeToOrder.isDisplayed());
		Assert.assertEquals(likeToOrder.getText().trim(), "We have a wide variety of freshly backed pizza . What would you like to Order ?");
		WebActions.print("Validated chatbot reply message 'We have a wide variety of freshly backed pizza . What would you like to Order ?'  sucessfully");
	}
	
	public static void selectVeg() {
		
		WebActions.waitForVisibility(selectVeg);
		WebActions.waitForclickable(send);
		selectVeg.click();	
		WebActions.print("Selected veg pizza ");

	}
	
	public static void selectcheeseCheckboxAndSubmit() {
		
		//WebActions.waitForVisibility(cheeseCheckbox);
		//WebActions.waitForclickable(cheeseCheckbox);
		cheeseCheckbox.click();	
		WebActions.print("Selected cheese Checkbox ");
		WebActions.waitForclickable(submit);
		submit.click();

	}
	
	public static void selectThickCrust() {
		
		WebActions.waitForVisibility(selectThickCrust);
		WebActions.waitForclickable(selectThickCrust);
		selectThickCrust.click();	
		WebActions.print("Selected Thick Crust pizza ");

	}
	
	public static void selectSmallSize() {
		
		WebActions.waitForVisibility(selectSmallSize);
		WebActions.waitForclickable(selectSmallSize);
		selectSmallSize.click();	
		WebActions.print("Selected Small Size pizza ");

	}
	public static void confirmOrderYes() {
		
		WebActions.waitForVisibility(confirmOrderYes);
		WebActions.waitForclickable(confirmOrderYes);
		WebActions.print("Your Pizza Will Look like this"+yourPizzaWillLooklikethis.getText().trim());
		confirmOrderYes.click();	
		WebActions.print("Confirmed the order");

	}
	
	public static void givethumbsUpFeedback() {
		WebActions.waitForVisibility(thumbsUp);
		thumbsUp.click();
		WebActions.print("Feedback given as thumbs-up ");

	}
	
	public static void submitFeedback() {
		WebActions.waitForVisibility(feedbackPick);
		feedbackPick.click();
		WebActions.waitForclickable(feedbackGood);
		feedbackGood.click();
		feedbackSubmit.click();
		WebActions.print("Feedback Submitted sucessfully ");


	}
}
