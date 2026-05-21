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
import org.openqa.selenium.support.ui.Select;

public class Appointmentbookings {

	
	public static void main(String[]args) throws EncryptedDocumentException, IOException, InterruptedException {
		
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
		
		driver.findElement(By.linkText("Make Appointment")).click();
		
//		driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();   //using xpath
		
		
		FileInputStream excel = new FileInputStream("C:\\Users\\praju\\OneDrive\\Desktop\\booking.xlsx");
		
		Sheet a = WorkbookFactory.create(excel).getSheet("Sheet1");
		
		String b = a.getRow(1).getCell(0).getStringCellValue();
		
		String c = a.getRow(4).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("txt-username")).sendKeys(b);
		
		driver.findElement(By.id("txt-password")).sendKeys(c);
		
		driver.findElement(By.id("btn-login")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement V = driver.findElement(By.id("combo_facility"));
		
		Select s = new Select(V);
		
		Thread.sleep(2000);
		
		s.selectByValue("Seoul CURA Healthcare Center");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.id("radio_program_medicare")).click();
		
		driver.findElement(By.id("txt_visit_date")).sendKeys("25/02/2026");
		
		driver.findElement(By.id("txt_comment")).sendKeys("prajwalcareer");
		
		driver.findElement(By.id("btn-book-appointment")).click();
		
		Thread.sleep(3000);
	
		
		String confirmation = driver.findElement(By.tagName("h2")).getText();
		

		Thread.sleep(3000);
		
		
        if (confirmation.equals("Appointment Confirmation")) {
        	
            System.out.println("Appointment booked successfully");
            
        } 
        
        else {
        	
            System.out.println(" Booking failed");
        }

        driver.quit();
		
}
}
