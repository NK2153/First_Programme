package org;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static TakesScreenshot ts;
	static Actions a;
	static File f;
	JavascriptExecutor js;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void getBrowser(String url) {
		driver.get(url);
	}

	public static WebElement findId(String valueid) {
		WebElement findElement = driver.findElement(By.id(valueid));
		return findElement;
	}

	public WebElement findName(String namevalue) {
		WebElement findElement = driver.findElement(By.name(namevalue));
		return findElement;
	}

	public WebElement findxpath(String xpathvalue) {
		WebElement findElement = driver.findElement(By.xpath(xpathvalue));
		return findElement;
	}

	public void sendtext(WebElement findElement, String textvalue) {
		findElement.sendKeys(textvalue);
	}

	public void buttonClick(WebElement findElement) {
		findElement.click();
	}

	public String textgetting(WebElement findElement) {
		String text = findElement.getText();
		System.out.println(text);
		return text;
	}

	public String gettingAttribute(WebElement findElement, String name) {
		String attribute = findElement.getAttribute(name);
		System.out.println(attribute);
		return attribute;
	}

	public void actionsMovetoElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public void actionsDragandDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public void actionsRightClick(WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
	}

	public void actionsDoubleClick(WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}

	public static void selectOptions(WebElement findElement, int index) {
		Select s = new Select(findElement);
		s.selectByIndex(index);
	}

	public static void selectOptions2(WebElement findElement, String value) {
		Select s = new Select(findElement);
		s.selectByValue(value);
	}

	public static void selectOptions3(WebElement findElement, String value) {
		Select s = new Select(findElement);
		s.selectByVisibleText(value);
	}

	public void simpleAlert() {
		Alert simple = driver.switchTo().alert();
		simple.accept();
	}

	public void confirmAlertAccept() {
		Alert confirm = driver.switchTo().alert();
		confirm.accept();
	}

	public void confirmAlertDismiss() {
		Alert alertdismiss = driver.switchTo().alert();
		alertdismiss.dismiss();

	}

	public void promtAlert(WebElement findElement, String value) {

		Alert promtalert = driver.switchTo().alert();
		findElement.sendKeys(value);
		promtalert.accept();

	}

	public File screenShot(String name) throws IOException {
		ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		f = new File("D:\\Files\\ss\\" + name + ".jpeg");
		FileUtils.copyFile(source, f);
		return source;

	}

	public void keyBoardActionsDown() {
		a.keyDown(Keys.DOWN);
		a.keyUp(Keys.DOWN);
		a.perform();
	}

	public void keyBoardActionsUp() {
		a.keyDown(Keys.UP);
		a.keyUp(Keys.UP);
		a.perform();
	}

	public void keyBoardActionsTab() {
		a.keyDown(Keys.TAB);
		a.keyUp(Keys.TAB);
		a.perform();
	}

	public void KeyBoardActionCopy() {
		a.keyDown(Keys.CONTROL);
		a.sendKeys("c");
		a.keyUp(Keys.CONTROL);
	}

	public void keyBoardActionAll() {
		a.keyDown(Keys.CONTROL);
		a.sendKeys("a");
		a.keyUp(Keys.CONTROL);
	}

	public void keyBoardActionsShift(String value, WebElement findElement) {
		a.keyDown(Keys.SHIFT);
		findElement.sendKeys(value);
		a.keyUp(Keys.SHIFT);
	}

	public void keyBoardActionsPaste() {
		a.keyDown(Keys.CONTROL);
		a.sendKeys("v");
		a.keyUp(Keys.CONTROL);
	}

	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void framesId(String id) {
		driver.switchTo().frame(id);
	}

	public void framesName(String name) {
		driver.switchTo().frame(name);
	}

	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public void windowHandles(String windowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String aa : windowHandles) {
			if (!aa.equals(windowHandle)) {
				driver.switchTo().window(aa);

			}

		}

	}

	public void switchingWindow(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	public void multiWindow(int index, String nameOrHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new LinkedList<String>();
		li.addAll(windowHandles);
		li.get(index);
		driver.switchTo().window(nameOrHandle);
	}

	public void findRows(String tagName) {
		List<WebElement> row = driver.findElements(By.tagName(tagName));
		int size = row.size();
		System.out.println(size);

	}

	public void findTableDatas(String tagName) {
		List<WebElement> tabledata = driver.findElements(By.tagName(tagName));
		int size = tabledata.size();
		System.out.println(size);
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public void javaScriptExecutorpixeldown(int number) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,number)");
	}

	public void javaScriptExecutorpixelup(int number) {
		js.executeScript("window.scrollBy(0,-number)");
	}

	public void javaScriptup(WebElement findElement) {
		js.executeScript("arguments[0].scrollIntoView(false)", findElement);
	}

	public void javaScriptDown(WebElement findElement) {
		js.executeScript("arguments[0].scrollIntoView(true)", findElement);
	}

	public void javaScriptvalue(String name, WebElement findElement) {
		js.executeScript("arguments[0].setAttribute('value',+'" + name + "')", findElement);
	}

	public void javaScriptHighlight(String colour, String bcolour, WebElement findElement) {
		js.executeScript("arguments[0].setAttribute('style','background:" + colour + ";border:" + bcolour + ")",
				findElement);
	}

	public void textClear(WebElement findElement) {
		findElement.clear();
	}
}
