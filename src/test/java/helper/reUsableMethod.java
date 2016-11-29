package helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class reUsableMethod {
	public static String dest;

	public static String captureScreenMethod(WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		dest ="E:\\Reports\\allScreenShots\\"+System.currentTimeMillis()+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}
}
