package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import Configuration.Conf;
import Configuration.TestExec;
import Configuration.Xpath_Conf;

public class Test0_11 implements TestExec {

	public void execute() {
		Conf.logger.info("****Test 0.11****");
		Dimension size;

		try {
			
			Conf.auto.driver.findElement(By.xpath(Xpath_Conf.tse_username)).click();
			Conf.logger.info("Ecriture du nom d'utilisateur");
			Conf.auto.driver.findElement(By.xpath(Xpath_Conf.tse_username)).sendKeys(Conf.tse_login);
			Conf.auto.driver.hideKeyboard();

			Conf.logger.info("Clique sur le bouton Connexion ");
			Conf.auto.driver.findElement(By.xpath(Xpath_Conf.tse_logIn)).click();

			size = Conf.auto.driver.manage().window().getSize();
			System.out.println(size);

			// Find swipe start and end point from screen's with and height.
			// Find startx point which is at right side of screen.
			int startx = (int) (size.width * 0.70);
			// Find endx point which is at left side of screen.
			int endx = (int) (size.width * 0.30);
			// Find vertical point where you wants to swipe. It is in middle of
			// screen height.
			int starty = size.height / 2;

			// Swipe from Right to Left.
			Thread.sleep(5000);
			Conf.logger.info("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
			Conf.auto.driver.swipe(startx, starty, endx, starty, 500);
			Thread.sleep(2000);

			// Swipe from Left to Right.
			Conf.logger.info("startx = " + endx + " ,endx = " + startx + " , starty = " + starty);
			Conf.auto.driver.swipe(endx - 100, starty, startx, starty, 500);
			Thread.sleep(2000);

			Conf.logger.info("****Test 0.11    OK****");

		} catch (NoSuchElementException p) {

			Conf.logger.warn("An element could not be located on the page using the given search parameters");
			Conf.logger.info("Test 0.11 KO ");

		} catch (UnreachableBrowserException e) {

			Conf.logger.warn("Unreachable Browser : Connection problem occured");
			Conf.logger.info("Test 0.11 KO ");

		} catch (WebDriverException p) {

			Conf.logger.warn(" Web Driver : Connection problem occured");
			Conf.logger.info("Test 0.11 KO ");

		} catch (Exception e) {

			Conf.logger.warn("ERROR");
			Conf.logger.info("Test 0.11 KO ");
		}

	}

}
