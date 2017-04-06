/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwebdriver;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Админ
 */
public class TestMethods {    
   //Проверка ссылок на внешние ресурсы на кликабельность и правильный адрес,
   //str - актуальный Url, скопированный из html-кода
   public void checkLink(WebDriver driver, WebElement element, String str)
   {   
    (new WebDriverWait(driver, 30))
    .until(ExpectedConditions.elementToBeClickable((element))).click();
    String c = element.getAttribute("href");
    assertEquals(str, c);
   }
   
   //Проверка элементов внутри сайта на кликабельность и переход на новую страницу
   public void clickElement(WebDriver driver, WebElement element) throws InterruptedException
   {
    String c = driver.getTitle();
    element.click();
    (new WebDriverWait(driver, 30))
    .until(ExpectedConditions.urlContains("/"));
    Thread.sleep(1000);
    String d = driver.getTitle();
    assertFalse(c.equals(d));
   }
   
   //Метод для проверки заголовков страницы 
   public void checkPage(WebDriver driver, WebElement element) throws InterruptedException
   {
    String c = element.getText();
    (new WebDriverWait(driver, 30))
    .until(ExpectedConditions.elementToBeClickable((element))).click();
    Thread.sleep(1000);
    String p = driver.getTitle();
    assertTrue(p.contains(c));
   }
   
   // Метод для проверки наличия текста на странице
   public void checkPageText(WebDriver driver, WebElement element)
   {
    (new WebDriverWait(driver, 30))
    .until(ExpectedConditions.elementToBeClickable((element))).click();
    String c = driver.getPageSource();
    assertNotNull(c);
   }
   public boolean checkImg(BufferedImage img)
        {
        int w = img.getWidth();
        int h = img.getHeight();
        int t = img.getRGB(0, 0); // цвет пискеля в верхнем левом углу
        boolean bool = false; 
        for (int y = 0; y < h; y++)
        for (int x = 0; x < w; x++) {
// если пиксель не совпадает с верхним левым то изображение не пустое.
        if (img.getRGB(x, y) != t)
        bool = true;
            }
        return bool;
        }
   
   //Проверка массивов с именами игроков
   public void checkArraysWithNamesOfMainPart(WebDriver driver, List<WebElement>list1)
   {
      //Наполним массив именами игроков
        List<String> list = Arrays.asList("Кенни Бойнтон", "Максим Григорьев", "Сергей Марихин", "Александр Гудумак",
        "Иван Викторов", "Сийм-Сандер Вене", "Томислав Зубчич", "Георгий Жбанов", "Дмитрий Узинский",
        "Петр Губанов", "Иван Стребков", "Илья Попов", "Дижон Томпсон", "Никита Зверев");
        List<String>list2 = new ArrayList<>();
        for(WebElement el:list1)
        {
        list2.add(el.getText());
        }
        assertArrayEquals(list.toArray(), list2.toArray());
        }
   
   //Тестирование поиска
   public void checkSeach(WebDriver driver) throws InterruptedException
   {
        MainPage mp = new MainPage();       
//Ключевые слова, по которым будем тестировать поиск
        String c1 = "цска";
        String c2 = "нижний новгород";
        String c3 = "уникс";
        List<String> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        int in = 0;
        for(String str : list)
        {
        mp.seachOnTheSite(driver).sendKeys(str);
        mp.seachOnTheSite(driver).sendKeys(Keys.ENTER);
        (new WebDriverWait(driver, 30))
        .until(ExpectedConditions.elementToBeClickable
        (By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/div[2]/ol/li[1]/h3/a"))).click();
        if(driver.getPageSource().toLowerCase().contains(str)) in++;
        Thread.sleep(1000);
        }
       assertTrue(in>=3);
        }
        }
