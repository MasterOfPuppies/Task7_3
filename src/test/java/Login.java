import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class Login {
    WebDriver selenium;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp(){
        selenium = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown(){
        selenium.close();
    }

    @Test
    public void loginTest(){
        loginPage = new LoginPage(selenium);
        LoginPage.load();
        homePage = LoginPage.login("eugenborisik","1");
        assertTrue(HomePage.isSignoutPresent());
    }

    @Test
    public void signoutTest(){
        loginPage = new LoginPage(selenium);
        LoginPage.load();
        homePage = LoginPage.login("eugenborisik","1");
        loginPage = HomePage.signOut();
        LoginPage.isLoaded();
    }
}
