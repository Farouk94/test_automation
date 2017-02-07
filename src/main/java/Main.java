
import javax.xml.bind.JAXBException;



import Configuration.Conf;
import Configuration.Run;

public class Main {

	public static void main(String[] args) {

		// Lancement des tests choisis

		try {
			Run.init();
			//Automation.lancerAvecXml(ArrayOfTests.arrayOfTests, 0, 4, 0, 4);
		} catch (JAXBException e) {

			Conf.logger.debug("Check the Marshalling : XML file may be the problem");
		}

	}

}
