package web.testgit.devrabbittest.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import web.testgit.devrabbittest.webpageclasses.Home_Screen;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC_HomePage extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;	public static final int datasetsLength = 1;

	public TC_HomePage() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC_HomePage.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc_homepage.properties");
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, Home_Screen.projectName);
		test = reports.startTest("TC_HomePage");
	}
	
	public void setUP() throws Exception {
		String primaryInfo = Home_Screen.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(new JSONObject(primaryInfo).optString("browser_type"), configFileObj);
	}

	public void Home_ScreenTest(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		Home_Screen objHome_Screen = PageFactory.initElements(driver, Home_Screen.class);
		testLogHeader(test, "Verify Home_Screen page");
		objHome_Screen.clkAContact_289294();
		printSuccessLogAndReport(test, logger,  "Text is displayed as : ContactLink");

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		isElementDispalyed = true;
		for(int datasets = 1; datasets <= Home_Screen.datasetsLength; datasets++) {
			if(!isElementDispalyed) return;			
			setUP();
			if(isElementDispalyed) { Home_ScreenTest(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}