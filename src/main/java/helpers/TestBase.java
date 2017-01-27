package helpers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class TestBase 
{
	private static ThreadLocal<Config[]> threadLocalConfig = new ThreadLocal<Config[]>();
	
	@BeforeSuite
	public void beforeSuite()
	{
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		
	}
	
	@DataProvider(name = "getTestConfig")
	public Object[][] getTestConfiguration()
	{
		Config config = new Config();
		threadLocalConfig.set(new Config[]{config});
		return new Object[][]{{config}};
	}
	
	@AfterMethod
	public void afterMethod()
	{
		Config[] testConfigs = threadLocalConfig.get();
		  for (Config testConfig : testConfigs)
		  {
			  if(testConfig.driver != null)
			  {
				  testConfig.driver.quit();
				  testConfig.logComment("Browser closed successfully.");
			  }
		  }
	}
}