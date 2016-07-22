import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver selenium;

    public HomePage(WebDriver selenium) {
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);
    }

    public static LoginPage signOut(){
        signOutClick();
        return new LoginPage(selenium);
    }

    private static void signOutClick(){

        selenium.findElement(By.cssSelector(".sign-out-span>a")).click();
    }

    public static boolean isSignoutPresent(){

        return selenium.findElement(By.cssSelector(".sign-out-span>a")).isDisplayed();
    }
}
