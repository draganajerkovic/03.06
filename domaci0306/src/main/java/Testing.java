import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testing {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private ManagerLoginPage managerLoginPage;

    private CreateCustomer createCustomer;

    private OpenAccount openAccount;

    private LoginCustomer loginCustomer;
    private Deposit deposit;

    private Withdrawl withdrawl;

    private ManagerLogout managerLogout;

    private CustomerLogout customerLogout;



    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        managerLoginPage=new ManagerLoginPage(driver, driverWait);
        createCustomer =new CreateCustomer(driver, driverWait);
        loginCustomer=new LoginCustomer(driver, driverWait);
        openAccount=new OpenAccount(driver, driverWait);
        deposit=new Deposit(driver, driverWait);
        withdrawl=new Withdrawl(driver, driverWait);
        managerLogout=new ManagerLogout(driver, driverWait);
        customerLogout=new CustomerLogout(driver, driverWait);
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }


    @Test (priority = 1)
    public void loginTest(){
        managerLoginPage.clickLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(createCustomer.getDriver().findElement
                (By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).getText(),"Add Customer");
    }


    @Test (priority = 2)
    public void createCustomerTest(){
        createCustomer.clickAddCustomerButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createCustomer.FillInInputFields();
        createCustomer.clickAddCustomerButton();
        //form-control ng-touched ng-dirty ng-invalid ng-invalid-required
        Assert.assertEquals(createCustomer.classNameChange(), "form-control ng-dirty ng-touched ng-invalid ng-invalid-required");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test(priority = 3)
//    public void openAccountTest(){
//        openAccount.clickOpenAccount();
//        openAccount.chooseCustomer();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        openAccount.clickProcess();
//
//        Assert.assertEquals(openAccount.classNameChange1(), "form-control ng-touched ng-dirty ng-invalid ng-invalid-required");
//
//    }


    @Test (priority = 4)
        public void loginAsCustomer(){
        loginCustomer.clickHomebutton();
        loginCustomer.clickLogAsCustomer();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginCustomer.ChooseAName();
        loginCustomer.clickToLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(loginCustomer.text(),"Harry Potter");
    }

    @Test(priority = 5)
    public void depositTest(){
        deposit.clickDepositButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        deposit.addAmount();
        Assert.assertEquals(deposit.confirmation(), "Deposit Successful");
    }

    @Test(priority = 6)
    public void withdrawlTest(){
        withdrawl.clickWithdrawlButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        withdrawl.withdrawAmount();
        Assert.assertEquals(withdrawl.confirmationWithdrawl(), "Transaction successful");
    }

//    @Test (priority = 7)
//    public void bmLogout(){
//        managerLogout.clickLogout();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Assert.assertEquals(managerLogout.logoutText(),"Your Name :");
//        managerLogout.homeButtonClick();
//    }

    @Test (priority = 8)
    public void cstmrLogout(){
        customerLogout.clickLogout();
        Assert.assertEquals(customerLogout.logoutText(),"Your Name :");
    }
}

