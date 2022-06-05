import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerLogout extends BasePage{

    private By logoutManager=By.xpath("/html/body/div/div/div[1]/button[2]");
    private By tekstAfterLogout=By.xpath("/html/body/div/div/div[2]/div/form/div/label");
    private By homeButton=By.xpath("/html/body/div/div/div[1]/button[1]");


    public ManagerLogout(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLogout(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", logoutManager);

    }

    public String logoutText(){
        return getDriver().findElement(tekstAfterLogout).getText();
    }

    public void homeButtonClick(){

            getDriver().findElement(homeButton).click();
        }
}
