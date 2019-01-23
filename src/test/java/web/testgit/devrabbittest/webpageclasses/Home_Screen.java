package web.testgit.devrabbittest.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Home_Screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":7,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"http://www.devrabbit.com/\",\"report_upload_url\":\"https://192.168.1.142:8080/TAF_Automation_DR/UploadReportFile\",\"project_name\":\"TestGit\",\"project_description\":\"e\",\"project_id\":196,\"module_name\":\"DevrabbitTest\",\"module_description\":\"\",\"sub_module_id\":0,\"module_id\":340,\"testcase_name\":\"TC_HomePage\",\"testcase_id\":404,\"testset_id\":0,\"executed_timestamp\":2053156955,\"browser_type\":\"chrome\"}";

	public static String projectName = "testgit";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Home_Screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//LI[@id='menu-item-1476']/A[1]")	
	private WebElement	Contact_289294A;
	public void clkAContact_289294() {
		waitForExpectedElement(driver, Contact_289294A);		
		String text = Contact_289294A.getText();
		Contact_289294A.click();
	}

}