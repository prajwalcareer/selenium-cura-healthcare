package againnnn;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appointmentbookings {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--incognito"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

		driver.findElement(By.linkText("Make Appointment")).click();

		FileInputStream excel = new FileInputStream("C:\\Users\\praju\\OneDrive\\Desktop\\booking.xlsx");

		Sheet a = WorkbookFactory.create(excel).getSheet("Sheet1");

		String b = a.getRow(1).getCell(0).getStringCellValue();

		String c = a.getRow(4).getCell(1).getStringCellValue();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt-username")));
		driver.findElement(By.id("txt-username")).sendKeys(b);

		driver.findElement(By.id("txt-password")).sendKeys(c);

		driver.findElement(By.id("btn-login")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility")));
		WebElement V = driver.findElement(By.id("combo_facility"));

		Select s = new Select(V);

		s.selectByValue("Seoul CURA Healthcare Center");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.id("radio_program_medicare")).click();

		driver.findElement(By.id("txt_visit_date")).sendKeys("25/02/2026");

		driver.findElement(By.id("txt_comment")).sendKeys("prajwalcareer");

		driver.findElement(By.id("btn-book-appointment")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
		String confirmation = driver.findElement(By.tagName("h2")).getText();

		if (confirmation.equals("Appointment Confirmation")) {

			System.out.println("Appointment booked successfully");

		} else {

			System.out.println(" Booking failed");
		}

		driver.quit();

	}
}
