/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwebdriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Rectangle;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;

/**
 *
 * @author Админ
 */
class MainPage {
    
//    WebDriver driver= new ChromeDriver();
     
    public void setUp()
    {
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.get("http://www.nn-basket.ru/");
    }
   //Методы для левого меню с социальными сетями
    public WebElement nnbasketVKLeft(WebDriver driver)
    {
        WebElement el = driver.findElement(By.cssSelector("a[href='http://vk.com/nnbasket']"));
        return el;        
    }
     public WebElement nnbasketFBLeft(WebDriver driver)
    {
        WebElement el = driver.findElement(By.cssSelector("a[href='https://www.facebook.com/nnbasket']"));
        return el;        
    }
      public WebElement nnbasketTwitterLeft(WebDriver driver)
    {
        WebElement el = driver.findElement(By.cssSelector("a[href='https://twitter.com/BC_NN']"));
        return el;        
    }
       public WebElement nnbasketInstaLeft(WebDriver driver)
    {
        WebElement el = driver.findElement(By.cssSelector("a[href='http://instagram.com/nn_basket']"));
        return el;        
    }
        public WebElement nnbasketYtubLeft(WebDriver driver)
    {
        WebElement el = driver.findElement(By.cssSelector("a[href='http://www.youtube.com/user/nnbasket']"));
        return el;        
    }
    //Методы для центрального окошка со слайдами
        //Первый слайд со ссылкой на новость
        public WebElement centrSlide(WebDriver driver)
        {
            driver.navigate().refresh();
             WebElement el = (new WebDriverWait(driver, 30))
.until(ExpectedConditions.elementToBeClickable((By.xpath(".//*[@id='slider']/div[2]/a"))));
            return el;
        }
        //Выбрать картинку на слайде из вебэлемента
        public BufferedImage imgChoice(WebDriver driver, WebElement el) throws IOException, InterruptedException
        {   
       // Делаем скриншот страницы 
//    el.sendKeys(Keys.ARROW_UP);
    Thread.sleep(1000);
    File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    // Создаем экземпляр BufferedImage для работы с изображением
    BufferedImage img = ImageIO.read(screen);
//    ImageIO.write(img, "png", new File("image.bmp"));
    // Получаем размеры элемента
            
    int width = el.getSize().getWidth();
    int height = el.getSize().getHeight();
    // Создаем прямоуголник (Rectangle) с размерами элемента
    Rectangle rect = new Rectangle(width, height);
    // Получаем координаты элемента
    Point p = el.getLocation();
    // Вырезаем изображенеи элемента из общего изображения
    System.out.println(img.getHeight()+" "+ p.getY()+" "+rect.height);
    BufferedImage dest = img.getSubimage(p.getX(), (int)(p.getY()/1.5), rect.width, rect.height);
    ImageIO.write(dest, "png", new File("image.bmp"));
    return dest;
        }
        
        //Первая новость под центральным слайдом
        public WebElement centrNews(WebDriver driver) throws InterruptedException
        {
            driver.navigate().refresh();
            WebElement el = (new WebDriverWait(driver, 30))
.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='news-item-link']")));
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", el);
el.sendKeys(Keys.ARROW_DOWN);
Thread.sleep(1000);
return el; 
        }
        //Элемент справа от слайда - Купить билет
        public WebElement rightBuyTicket(WebDriver driver)
        {
            driver.navigate().refresh();
            WebElement el = (new WebDriverWait(driver, 30))
.until(ExpectedConditions.elementToBeClickable
        ((By.cssSelector("a[class='js-unifd-trigger-link nn-buy-tickets']"))));
            return el;  
        }
        //Элемент справа от слайда с анонсом и ссылкой на календарь, где время игры
        public WebElement rightAnons(WebDriver driver)
        {
           driver.navigate().refresh();
            WebElement el = (new WebDriverWait(driver, 30))
.until(ExpectedConditions.elementToBeClickable
        ((By.cssSelector("a[class='all-block-link']"))));
            return el;    
        }
        
        public WebElement imgCentrNews(WebDriver driver) throws InterruptedException
        {
           driver.navigate().refresh();
            WebElement el = (new WebDriverWait(driver, 30))
.until(ExpectedConditions.visibilityOfElementLocated
        ((By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div[3]/div/div[3]/div[1]"))));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", el);        
             return el;    
        }
       
        //Команда - основной состав - имена игроков
        public List mainTeamMainPartNamesOfPlayers(WebDriver driver)
        {
           driver.get("http://www.nn-basket.ru/team/main-team/2016-2017/");
       List<WebElement> list =  driver.findElements(By.xpath
        ("html/body/div[5]/div[1]/div[2]/div[1]/div[2]/div[position()>=3]/div/a"));  
            return list;
        }
        
        //Поиск по сайту
        public WebElement seachOnTheSite(WebDriver driver)
        {
            WebElement el = (new WebDriverWait(driver, 30))
.until(ExpectedConditions.elementToBeClickable
        ((By.cssSelector("input[class='text-input']"))));
            return el;
        }
}
