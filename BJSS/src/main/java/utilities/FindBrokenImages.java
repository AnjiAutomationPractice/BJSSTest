package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.BaseObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static pageobjects.BaseObject.driver;

public class FindBrokenImages  {


    public static void findBrokenImages()
    {
        List<WebElement> Images=driver.findElements(By.tagName("img"));
        System.out.println("Total Images are"+Images.size());
        for(int i=0;i<Images.size();i++)
        {
            WebElement element=Images.get(i);
            String url=element.getAttribute("src");
            verifyLinkActive(url);
        }
    }
    public static void verifyLinkActive(String linkUrl)
    {
        try{
            URL url=new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+"-"+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+"-"+HttpURLConnection.HTTP_NOT_FOUND);
            }

        }catch(Exception e){

        }
    }

    }

