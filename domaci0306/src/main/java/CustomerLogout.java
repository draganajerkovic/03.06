import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLogout extends BasePage{

    private By logoutButtonCustomer=By.xpath("/html/body/div/div/div[1]/button[2]");
    private By textAfterLogout=By.xpath("/html/body/div/div/div[2]/div/form/div/label");


    public CustomerLogout(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLogout(){
        getDriver().findElement(logoutButtonCustomer).click();
    }

    public String logoutText(){
        return getDriver().findElement(textAfterLogout).getText();
    }
}
