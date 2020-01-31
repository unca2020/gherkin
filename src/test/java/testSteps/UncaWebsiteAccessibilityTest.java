package testSteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demoCucumber.project.pages.GoogleHomePage;
import demoCucumber.project.pages.GoogleResultPage;
import demoCucumber.project.pages.UncaHomePage;

import java.util.concurrent.TimeUnit;

/**
 * Classe de test Cucumber
 */
public class UncaWebsiteAccessibilityTest {

	/** Driver utilise pour interagir avec les objets web */
	private WebDriver driver;

	/** Tiemout intelligent pour eviter les faux positifs */
	private WebDriverWait timeout;

	GoogleHomePage googleHomePage;
	GoogleResultPage googleResultPage;
	UncaHomePage uncaHomePage;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		timeout = new WebDriverWait(driver, 5);

	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("I am on the google web page")
	public void i_am_on_the_google_web_page() {
		driver.get("http://www.google.com");
		googleHomePage = new GoogleHomePage(driver);

	}

	@When("I look for {}")
	public void i_look_for_smt(String word) {
		googleResultPage = googleHomePage.searchForAword(timeout, word);
	}

	@When("click on the result")
	public void click_on_the_result() {
		uncaHomePage = googleResultPage.clickOnResultLink(timeout);
	}

	@Then("I am on the page of Unca")
	public void i_am_on_the_page_of_Unca() {
		System.out.println(driver.getTitle());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("unca", driver.getTitle());

	}
}
