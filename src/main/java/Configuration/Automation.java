package Configuration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

import XML_Config.Device;
import XML_Config.Devices;
import XML_Config.Global_Conf;
import XML_Config.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Automation {
	public TestExec exec;

	DesiredCapabilities capabilities;
	public AppiumDriver driver;
	int timeOut = 180;
	int port = -1;

	public Automation(int port) {
		this.port = port;
	}

	/*
	 * Permet d'appeler une classe a partir de son nom.
	 */

	public static TestExec instancier(String ClassName) {
		try {
			Class<?> clazz = Class.forName(ClassName);

			return (TestExec) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			Conf.logger.debug("ClassNotFoundException ");
		} catch (InstantiationException e) {
			Conf.logger.debug("InstantiationException", e);
		} catch (IllegalAccessException e) {
			Conf.logger.debug("", e);
		}

		return null;
	}

	/*
	 * Prends une liste de tests , un niveau de test de depart ,un numero de
	 * test de depart, un niveau de test de fin et un numero de test de fin
	 * 
	 * Transforme les Integer que contient la liste et cree un string
	 * correspondant au nom de la classe d'un test specifique
	 * 
	 * Lance l'execution du test en utilisant la methode instancier qui prends
	 * en parametre le string cree .
	 */

	public static void lancer(int firstlvl, int numOftest) {

		Conf.exec = instancier("Tests.Test" + firstlvl + "_" + numOftest);

		Conf.exec.execute();

	}

	public static void lancer(List<Test> tab, int firstlvl, int numOftest, int secondlvl, int numoftest2) {

		for (int i = searchIndexOf(firstlvl, numOftest, tab); i <= searchIndexOf(secondlvl, numoftest2, tab); i++) {

			Conf.exec = instancier("Tests.Test" + tab.get(i).getLevel() + "_" + tab.get(i).getNumber());

			Conf.exec.execute();

		}

	}

	/*
	 * Permet de retrouver l'index d'un couple (niveau,numero de test) dans
	 * notre liste de tests
	 */
	public static int searchIndexOf(int a, int b, List<Test> namesAndNumbers) {
		for (int i = 0; i < namesAndNumbers.size(); i++)

		{

			if (namesAndNumbers.get(i).getLevel() == a & namesAndNumbers.get(i).getNumber() == b) {
				return i;

			}

		}
		return -1;
	}

	/*
	 * Permet d'initialiser le driver pour établir la connexion avec l'appareil
	 * .
	 */
	public void runAndroid(String p) throws Exception {

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("udid", p);
		capabilities.setCapability("deviceName", p);
		capabilities.setCapability("appPackage", "air.TSEssentialFlex");
		capabilities.setCapability("appActivity", "com.virtualinstinct.tsessential.CalendarActivity");
		capabilities.setCapability("app", Conf.androidapk);
		driver = new AndroidDriver(new URL("http://0.0.0.0:" + this.port + "/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Conf.logger.info("Connecté à l'apprareil");

	}

	/*
	 * Permet de shutdown le driver afin de se déconnecter avec l'appareil
	 */

	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
