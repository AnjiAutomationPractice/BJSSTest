package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.BaseObject;

import java.util.Set;

import static pageobjects.BaseObject.driver;

public class MultipleWindowsHandle extends BaseObject {

    //private static WebDriver driver;
    public static String Parent_Window =driver.getWindowHandle();

    public MultipleWindowsHandle(WebDriver driver) {super(driver); }

    public static void switchToChildWindow(){
        Set<String> Handles = driver.getWindowHandles();
        for (String Child_Window:Handles){
            if(!Child_Window.equals(Parent_Window)){
                driver.switchTo().window(Child_Window);
                Wait.wait1sec();
            }
        }
    }

    public static void switchToParentWindow(){
        driver.switchTo().window(Parent_Window);
    Wait.wait1sec();}
}
