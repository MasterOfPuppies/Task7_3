import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage{

    private static WebDriver selenium;
    private static String str = "RMSys - Sign In";
    private static String url = "https://192.168.100.26/";

    public LoginPage(WebDriver selenium){
        this.selenium = selenium;
    }

    public static void load(){
        selenium.get(url);
    }

    public static void isLoaded(){

        Assert.assertTrue(selenium.getTitle().equals(str));
    }

    private static void inputData(String username, String password){
        selenium.findElement(By.cssSelector("#Username")).sendKeys(username);
        selenium.findElement(By.cssSelector("#Password")).sendKeys(password);
    }

    public static HomePage login(String username, String password){
        inputData(username, password);
        clickSubmit();
        return new HomePage(selenium);
    }

    private static void clickSubmit(){
        selenium.findElement(By.cssSelector("#SubmitButton")).click();
    }
}
