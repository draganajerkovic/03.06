import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCustomer extends BasePage{

    private By addCustomerButtonClick=By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By firstNameInputField=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastNameInputField=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");

    private By addCustomerButtonBottom =By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


    public CreateCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAddCustomerButton(){
        getDriver().findElement(addCustomerButtonClick).click();
    }
    public void FillInInputFields() {
        getDriver().findElement(firstNameInputField).sendKeys("Marko");
        getDriver().findElement(lastNameInputField).sendKeys("Markovic");
        getDriver().findElement(postCode).sendKeys("N215G04");
        getDriver().findElement(postCode).sendKeys(Keys.ENTER);
        getDriver().switchTo().alert().accept();

    }
    public String classNameChange() {
            return getDriver().findElement(firstNameInputField).getAttribute("class");
        }

}
