package Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import XML_Config.Device;
import XML_Config.Devices;
import XML_Config.Global_Conf;
import XML_Config.Level;
import XML_Config.Levels;
import XML_Config.Test;

/*
 * Permet de lire les fichiers xml placé dans src.main.resources et de lancer les tests voulu en mettant true ou false 
 */
public class Run {

	public static void init() throws JAXBException {

		// Lecture des fichiers xml

		JAXBContext jaxbContext = JAXBContext.newInstance(Devices.class);
		JAXBContext jaxbContext1 = JAXBContext.newInstance(Global_Conf.class);
		JAXBContext jaxbContext2 = JAXBContext.newInstance(Levels.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Unmarshaller jaxbUnmarshaller1 = jaxbContext1.createUnmarshaller();
		Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
		Devices devices = (Devices) jaxbUnmarshaller.unmarshal(new File("src\\main\\resources\\devices.xml"));
		Global_Conf glob = (Global_Conf) jaxbUnmarshaller1.unmarshal(new File("src\\main\\resources\\USB_or_Wifi.xml"));
		Levels levels = (Levels) jaxbUnmarshaller2.unmarshal(new File("src\\main\\resources\\Run.xml"));

		for (Device device : devices.getDevices()) {
			if (device.isUp() & glob.isUSB()) {

				// Lancement du driver de connexion

				Conf.logger.info("Commencement des Tests sur " + device.getName());
				Conf.logger.info("Mode USB activé");
				try {
					Conf.auto.runAndroid(device.getUsb_id());

				} catch (UnreachableBrowserException e) {

					Conf.logger.warn("Unreachable Browser : Connection problem occured");
					break;

				} catch (WebDriverException c) {

					Conf.logger.warn(" Web Driver : Connection problem occured");
					break;

				} catch (InterruptedException e) {

					Conf.logger.warn("Thread interupted ");
					break;

				} catch (Exception e) {

					Conf.logger.warn("ERROR");
					break;

				}

				for (Level level : levels.getLevels()) {
					if (level.isUp()) {
						// Lancement d'un niveau complet de connexion
						List<Test> temp = new ArrayList<>();
						for (Test test : level.getTests()) {

							temp.add(new Test(test.getLevel(), test.getNumber()));

						}
						// Boucler sur l'ensemble du temp qui contient le niveau
						// de test et le numéro de test de chaque test du niveau
						// choisi

						Automation.lancer(temp, temp.get(0).getLevel(), temp.get(0).getNumber(),
								temp.get(temp.size() - 1).getLevel(), temp.get(temp.size() - 1).getNumber());

						Conf.auto.tearDown();

					}

					for (Test test : level.getTests()) {
						if (!level.isUp() & test.isUp()) {
							// lancement du subniveau choisi
							Automation.lancer(test.getLevel(), test.getNumber());

						}

					}
					Conf.auto.tearDown();

				}

			}

			else if (device.isUp() & glob.isWifi()) {

				// Lancement du driver de connexion

				Conf.logger.info("Commencement des Tests sur " + device.getName());
				Conf.logger.info("Mode Wifi activé");
				try {
					Conf.auto.runAndroid(device.getWifi_id());

				} catch (UnreachableBrowserException e) {

					Conf.logger.warn("Unreachable Browser : Connection problem occured");
					break;

				} catch (WebDriverException c) {

					Conf.logger.warn(" Web Driver : Connection problem occured");
					break;

				} catch (InterruptedException e) {

					Conf.logger.warn("Thread interupted ");
					break;

				} catch (Exception e) {

					Conf.logger.warn("ERROR");
					break;

				}

				for (Level level : levels.getLevels()) {
					if (level.isUp()) {
						// Lancement d'un niveau complet de connexion
						List<Test> temp = new ArrayList<>();
						for (Test test : level.getTests()) {
							// fct lancer du debut du niveau a sa fin

							temp.add(new Test(test.getLevel(), test.getNumber()));

						}
						// Boucler sur l'ensemble du temp qui contient le niveau
						// de test et le numéro de test de chaque test du niveau
						// choisi

						Automation.lancer(temp, temp.get(0).getLevel(), temp.get(0).getNumber(),
								temp.get(temp.size() - 1).getLevel(), temp.get(temp.size() - 1).getNumber());

						Conf.auto.tearDown();

					}

					for (Test test : level.getTests()) {
						if (!level.isUp() & test.isUp()) {

							Automation.lancer(test.getLevel(), test.getNumber());

						}

					}
					Conf.auto.tearDown();

				}

			}

		}
	}

}
