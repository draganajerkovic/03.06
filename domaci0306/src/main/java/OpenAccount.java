import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccount extends BasePage{

    private By openAccountButton=By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customerNameList=By.xpath("//*[@id=\"userSelect\"]");
    private By currencyList=By.id("currency");
    private By process=By.id("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");




    public OpenAccount(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOpenAccount(){
        getDriver().findElement(openAccountButton).click();
    }

    public void chooseCustomer(){

        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Select dropDownName=new Select(getDriver().findElement(customerNameList));
        dropDownName.selectByVisibleText("Marko Markovic");


        Select dropDownCurrency=new Select(getDriver().findElement(currencyList));
        dropDownCurrency.selectByVisibleText("Dollar");
    }

    public void clickProcess(){

        getDriver().findElement(process).click();
        getDriver().switchTo().alert().accept();
    }

    public String classNameChange1() {
        return getDriver().findElement(customerNameList).getAttribute("class");
    }
}
