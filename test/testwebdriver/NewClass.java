/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwebdriver;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Админ
 */
public class NewClass {
    public static void main(String[] args) throws IOException
     {
      Result result = JUnitCore.runClasses(TestWebDriverTest.class);
        System.out.println(result.getFailureCount());
        Date date = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        File file = new File("F://", format1.format(date)+".txt");
        file.createNewFile();
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        for(Failure failure : result.getFailures())
{	
System.out.println(failure.getTestHeader());
    System.out.println(failure.getTrace());
    out.write(failure.getTestHeader());
    out.write(System.getProperty("line.separator"));
    out.write(failure.getTrace());
    out.write(System.getProperty("line.separator"));
}
System.out.println(result.wasSuccessful()); 
out.close();
     }
    
}
