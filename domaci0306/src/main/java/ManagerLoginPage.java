import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerLoginPage extends BasePage{
    private By loginButtonManager =By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");

    public ManagerLoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    //posebna metoda za click na login button
    public void clickLoginButton(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDriver().findElement(loginButtonManager).click();
    }



}
