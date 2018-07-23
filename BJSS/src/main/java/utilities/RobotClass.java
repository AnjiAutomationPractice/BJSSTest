package utilities;

import java.awt.*;
import java.awt.event.KeyEvent;
import static utilities.Wait.wait1sec;

public class RobotClass {

    public static void clickEnterFromKeyboard() throws AWTException {
        wait1sec();
        try{
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch(AWTException e){
            System.out.println(e);
        }
    }

    public static void clickDownFromKeyboard(){
        wait1sec();

        try{
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void copyAllText(){
        wait1sec();
        try{
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }


    public static void PasteText(){
        wait1sec();
        try{
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }



    public static void pressDelete(){
        wait1sec();
        try{
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);

        }catch (AWTException e){
            e.printStackTrace();
        }
    }



}