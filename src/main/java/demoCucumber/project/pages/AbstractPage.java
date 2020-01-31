package demoCucumber.project.pages;

import org.openqa.selenium.WebDriver;

/**
 * Mere de toutes les pages au sens Page Object pattern. Permets de simplement
 * avoir une seule et unqiue façon de transmettre le {@link WebDriver}.
 */
public abstract class AbstractPage {

	/**
	 * Driver permettant d interagir avec les objets reels des pages webs (btn,
	 * champs, liens, etc...)
	 */
	private final WebDriver driver;

	/**
	 * Contructeur de base permets de definir le driver
	 */
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Accesseur sur le driver pour que les filles puissent y avoir acces.
	 */
	public WebDriver getDriver() {
		return driver;
	}
}
