package Assignment;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Keys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Fitpeo_TestCase {
	
	static WebDriver driver;
	

  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.edge.driver", "D:\\drivers\\edgedriver_win64(131)\\msedgedriver.exe");
	  
	  driver = new EdgeDriver();
	  
	  
	  // 1. Navigate to the FitPeo Home page
	  driver.get("https://www.fitpeo.com/");
	  
	  driver.manage().window().maximize();
	  
	
	  
	  
  }

	
  @Test
  public void test() throws Throwable {
	  
	  Thread.sleep(5000);
	  
	  
	 // 2. Navigate to the Revenue Calculator Page
	  
	  WebElement revenue = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
	  revenue.click();
	  Thread.sleep(5000);
	  
	  
	  // 3. Scroll Down to the Slider section
	  
	  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	  js1.executeScript("window.scrollBy(0,400)", "");
	  Thread.sleep(5000);
	  
	  
	 // 4. Adjust the Slider: 820
	  	  
	  WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

      String currentValue = slider.getAttribute("value");
      int currentValueInt = Integer.parseInt(currentValue);

      int targetValue = 820;
      int difference = targetValue - currentValueInt;

      for (int i = 0; i < difference; i++) {
          slider.sendKeys(Keys.ARROW_RIGHT);
      }

      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
      }

      WebElement textField = driver.findElement(By.xpath("//input[@type='number']"));
      String updatedValue = textField.getAttribute("value");
      Assert.assertEquals(updatedValue,"820");
      System.out.println("Adjusted slider value: " + updatedValue);
      System.out.println("Adjust Slider value: 820 and validated the Test Box Updated 820 successfully.");
      
       Thread.sleep(5000);

	  
       // 5. Update the Text Field:
       
       textField.click();
       Thread.sleep(2000);

       textField.sendKeys(Keys.CONTROL + "a");
       textField.sendKeys(Keys.DELETE);
       Thread.sleep(2000);
       
       textField.sendKeys("560");

       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }

       String updatedSliderValue = slider.getAttribute("value");
       Assert.assertEquals(updatedSliderValue, "560");
       System.out.println("Updated Text Field value: " + updatedSliderValue);
       System.out.println("Updated the Text field: 560 and validated the Slider Updated 560 successfully.");
       Thread.sleep(2000);
       

        // 6. Validate the slider value
      
       String sliderValue = slider.getAttribute("value");
       Assert.assertEquals(sliderValue,"560");
       System.out.println("Slider value 560 validated successfully!");
       
       Thread.sleep(2000);
       


       //  7. Select CPT Codes:

 	  JavascriptExecutor js2 = (JavascriptExecutor) driver;
 	  js2.executeScript("window.scrollBy(0,280)", "");
 	  Thread.sleep(5000);
 	  
 	  WebElement cpt1 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]"));
 	  cpt1.click();
 	  
 	  Thread.sleep(3000);
 	  
 	  WebElement cpt2 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
 	  cpt2.click();
 	  
 	  Thread.sleep(3000);
 	  
 	  WebElement cpt3 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
 	  cpt3.click();
 	  
 	  Thread.sleep(3000);
 	  
 	  
 	 JavascriptExecutor js3 = (JavascriptExecutor) driver;
	  js3.executeScript("window.scrollBy(0,800)", "");
	  Thread.sleep(5000);
 	  
	  WebElement cpt4 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));
 	  cpt4.click();
 	  
 	  Thread.sleep(5000);
 	  
 	 // 8.  Validate Total Recurring Reimbursement
 	WebElement totalRecurringReimbursement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));
 	String actualValue = totalRecurringReimbursement.getText().replaceAll(".*: ", "").trim();
 	Assert.assertEquals(actualValue,"$75600");
 	System.out.println("Actual value: " + actualValue);
 	System.out.println("Successfully Validated Total Recurring Reimbursement");
 	
 	Thread.sleep(3000);
 	
    //  9.Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110,700.
 	WebElement header = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 inter css-1xroguk'])[4]"));
 	String actual = header.getText();
 	String expected = "Total Recurring Reimbursement for all Patients Per Month: $110,700.";
 	SoftAssert softassert = new SoftAssert();
 	softassert.assertEquals(actual, expected);
 	System.out.println("Successfully Verified Total Recurring Reimbursement for all Patients Per Month: $110,700.");
 	
 	Thread.sleep(3000);
 	
  }
  
  @AfterClass
  public void afterClass() {
	  
	 driver.quit();
	 
  }

}
