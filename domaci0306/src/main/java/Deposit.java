import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Deposit extends BasePage{

    private By depositButton=By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By amountField=By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By textDeposit=By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
    public Deposit(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void clickDepositButton(){
        getDriver().findElement(depositButton).click();
    }

    public void addAmount(){
        getDriver().findElement(amountField).sendKeys("1000");
        getDriver().findElement(amountField).sendKeys(Keys.ENTER);
    }

    public String confirmation(){
        return getDriver().findElement(textDeposit).getText();
    }
}
