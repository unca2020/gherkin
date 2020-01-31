package demoCucumber.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/*
 * Page au sens Page Object Pattern representant la page d acceuil de Google
 */
public class GoogleHomePage extends AbstractPage {

	/**
	 * Locateur de la barre de recherche.Il n'y a qu un seul champs texte.
	 */
	@FindBy(xpath = "//input[@type = 'text']")
	private WebElement inputArea;

	/**
	 * Locateur du bouton rechercher.
	 */
	@FindBy(name = "btnK")
	private WebElement rechercherBtn;

	/**
	 * Constructeur de base, initialisant en plus les locateurs specifiques
	 */
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public GoogleResultPage searchForAword(WebDriverWait timeout, String word) {
		timeout.until(visibilityOf(inputArea));
		inputArea.sendKeys(word);
		timeout.until(elementToBeClickable(rechercherBtn));
		rechercherBtn.click();
		return new GoogleResultPage(getDriver());
	}

}
