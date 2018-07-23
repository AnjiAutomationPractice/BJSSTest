package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import static pageobjects.BaseObject.driver;

public class FindBrokenLinks  {
    public static void findBrokenLinks()
    {
        Wait.wait5sec();
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total links are"+links.size());
        for(int i=0;i<links.size();i++)
        {
            WebElement element=links.get(i);
            String url=element.getAttribute("href");
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
