package pageObject;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class whoIsWatching extends baseMethods{

    private final By whoIsWatching = By.xpath("//h1[contains(text(), 'watching?')]");

    public whoIsWatching(WebDriver driver) {
        super(driver);
    }

    public void clickOnwhoIsWatching(String username) {
        explicitWait(whoIsWatching,20);
        try {
            if (driver.findElement(whoIsWatching).isDisplayed()) {
                driver.findElement(By.xpath("//*[text()='" + username + "']")).click();
            }
        }
        catch(java.lang.Exception e){
            System.out.println("User not found with the name "+username );
            driver.close();
        }
    }
}
