package bindings;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class stepDefinitions {
    WebDriver driver = null;
    List<List<String>> data = null;
    @Given("^The browser is open$")
    public void the_browser_is_open() throws Throwable {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("^The user is on the homepage$")
    public void the_user_is_on_the_homepage() throws Throwable {
        driver.navigate().to("http://localhost:8080/login/");
    }

    @When("^The user enters \"([^\"]*)\" in the username field$")
    public void the_user_enters_in_the_username_field(String username) throws Throwable {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);
    }

    @When("^The user enters \"([^\"]*)\" in the password field$")
    public void the_user_enters_in_the_password_field(String password) throws Throwable {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    @When("^The user presses the login button$")
    public void the_user_presses_the_login_button() throws Throwable {
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }

    @Then("^The system should display \"([^\"]*)\"$")
    public void the_system_should_display(String expected) throws Throwable {
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected, actual);
    }
    @Given("^This user$")
    public void this_user(DataTable table) throws Throwable {
        data = table.raw();
    }

    @When("^The user enters his username in the username field$")
    public void the_user_enters_his_username_in_the_username_field() throws Throwable {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(data.get(1).get(1));
    }

    @When("^The user enters his password in the password field$")
    public void the_user_enters_his_password_in_the_password_field() throws Throwable {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(data.get(2).get(1));
    }

    @After
    public void closeBrowser(Scenario scenario){
        driver.close();
        driver.quit();
    }
}
