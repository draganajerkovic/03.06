import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCustomer extends BasePage{

    private By homeButton=By.xpath("/html/body/div/div/div[1]/button[1]");
    private By loginCustomerButton=By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By chooseName=By.xpath("//*[@id=\"userSelect\"]");
    private By loginBottom=By.xpath("/html/body/div/div/div[2]/div/form/button");

    public LoginCustomer (WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickHomebutton(){

        getDriver().findElement(homeButton).click();
    }

    public void clickLogAsCustomer(){
        getDriver().findElement(loginCustomerButton).click();
    }

    public void ChooseAName(){
        Select dropDownName=new Select(getDriver().findElement(chooseName));
        dropDownName.selectByVisibleText("Harry Potter");
    }

    public void clickToLogin(){
        getDriver().findElement(loginBottom).click();
    }

    public String text(){
         return getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span")).getText();
    }
}
