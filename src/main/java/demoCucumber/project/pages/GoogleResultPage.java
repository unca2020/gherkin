package demoCucumber.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page de resutlat google pour une recherche sur la Dassault 3DS.
 */
public class GoogleResultPage extends AbstractPage {

	/**
	 * Locateur du lien vers le site de Dassault 3DS. Cest la premiere reponse.
	 */
	@FindBy(xpath = "(//div[@class = 'rc'])[1]/div/a")
	private WebElement resultLnk;

	/**
	 * Contructeur de base. Permets de definir le driver et d'initialiser les
	 * locateurs.
	 *
	 * @param driver
	 */
	public GoogleResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public UncaHomePage clickOnResultLink(WebDriverWait timeout) {
		timeout.until(ExpectedConditions.elementToBeClickable(resultLnk));
		resultLnk.click();
		return new UncaHomePage(getDriver());
	}
}
