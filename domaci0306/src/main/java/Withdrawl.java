import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Withdrawl extends BasePage{

    private By withdrawlButton=By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By amountWithdrawl=By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By textWithdrawl=By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");


    public Withdrawl(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickWithdrawlButton(){
        getDriver().findElement(withdrawlButton).click();
    }

    public void withdrawAmount(){
        getDriver().findElement(amountWithdrawl).sendKeys("1000");
        getDriver().findElement(amountWithdrawl).sendKeys(Keys.ENTER);
    }

    public String confirmationWithdrawl(){
        return getDriver().findElement(textWithdrawl).getText();
    }
}
