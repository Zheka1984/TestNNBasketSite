/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwebdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Админ
 */
public class TestWebDriverTest  {
    WebDriver driver;
    TestMethods tm = new TestMethods(); 
    MainPage mp = new MainPage();
 

@BeforeClass
public static void startclass(){
     System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");   
}

    @Before
public void start() { 
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    driver.get("http://www.nn-basket.ru/");
}
@After
public void theEnd(){
    driver.quit();
}
//@ClassRule
//    public static RetryRule retryRule = new RetryRule(3);
   
    @Test
    public void testVKTitle()
    {
       tm.checkLink(driver, mp.nnbasketVKLeft(driver), "http://vk.com/nnbasket"); 
    }
    @Test
    public void testFBTitle() throws InterruptedException {   
       tm.checkLink(driver, mp.nnbasketFBLeft(driver), "https://www.facebook.com/nnbasket");
    }
    @Test
    public void testTwitterTitle()
    {
      tm.checkLink(driver, mp.nnbasketTwitterLeft(driver), "https://twitter.com/BC_NN");  
    }
    @Test
    public void testInstaTitle()
    {
          tm.checkLink(driver, mp.nnbasketInstaLeft(driver), "http://instagram.com/nn_basket"); 
    }
    @Test
    public void testYtubLeft()
    {
        tm.checkLink(driver, mp.nnbasketYtubLeft(driver), "http://www.youtube.com/user/nnbasket");
    }
    
    //Проверка на кликабельность первого слайда
    @Test
    public void testCheckLinkCentrSlide() throws InterruptedException
    {
        tm.clickElement(driver, mp.centrSlide(driver));
    }
    
    // Проверка на корректность содержимого при клике на первом слайде
    @Test
    public void checkCentrSlide() throws InterruptedException
    {
        tm.checkPage(driver, mp.centrSlide(driver));
    }
    
    //Проверка наличия содержимого при клике первого слайда
    @Test
    public void testCheckLinCentrSlide()
    {
        tm.checkPageText(driver, mp.centrSlide(driver));
    }
    
    //Проверка наличия картинки на первом слайде
    public void testCheckImgCentrSlide() throws IOException, InterruptedException
    {
        tm.checkImg(mp.imgChoice(driver, mp.centrSlide(driver)));
    }
    
    //Анонс ближайшей дом. игры - проверка на корректность содержимого
    @Test
    public void checkRightAnons() throws InterruptedException
    {
        tm.checkPage(driver, mp.rightAnons(driver));
    }
    
    //Анонс ближайшей дом. игры - проверка наличия содержания на странице
    @Test
    public void testContentRightAnons()
    {
        tm.checkPageText(driver, mp.rightAnons(driver));
    }
    
    //Анонс ближ. дом. игры - проверка картинки
    @Test
    public void testImgRightAnons() throws Exception 
    {
        tm.checkImg(mp.imgChoice(driver, mp.rightAnons(driver)));
    }
    
    //Анонс ближ. дом. игры - проверка на переход на новую страницу
    @Test
    public void testChekLinkRightAnons() throws InterruptedException
    {
        tm.clickElement(driver, mp.rightAnons(driver));  
    }
    
    //Проверка первой новости на кликабельность
    @Test
    public void testClickCentrNews() throws InterruptedException
    {
        tm.clickElement(driver, mp.centrNews(driver));
    }
    
    @Test
    public void testPageTextCentrNews() throws InterruptedException
    {
        tm.checkPageText(driver, mp.centrNews(driver));
    }
    
    @Test
    public void testTitleCentrNews() throws InterruptedException
    {
        tm.checkPage(driver, mp.centrNews(driver));
    }
    
    @Test
    public void testImgCentrNews() throws IOException, InterruptedException
    {
        tm.checkImg(mp.imgChoice(driver, mp.imgCentrNews(driver)));
    }
    
    @Test
    public void testPageTextRightBuyTicket()
    {
        tm.checkPageText(driver, mp.rightBuyTicket(driver));
    }
    
    @Test
    public void testTitleRightBuyTicket() throws InterruptedException
    {
        tm.checkPage(driver, mp.rightBuyTicket(driver));
    }
    
    @Test
    public void testImgRightBuyTicket() throws IOException, InterruptedException
    {
       tm.checkImg(mp.imgChoice(driver, mp.rightBuyTicket(driver))); 
    }
    
    //Проверка состава игроков основной команды
    @Test
    public void testPlayersMainTeam() throws InterruptedException
    {
        tm.checkSeach(driver);
    }
}
    

