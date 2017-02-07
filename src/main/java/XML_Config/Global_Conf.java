package XML_Config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Classe necessaire au traitement des données lu dans le fichier xml

@XmlRootElement
public class Global_Conf {

	private boolean isUSB;

	private boolean isWifi;

	public Global_Conf() {
		super();
	}

	@XmlElement(name = "USB")

	public boolean isUSB() {
		return isUSB;
	}

	public void setUSB(boolean isUSB) {
		this.isUSB = isUSB;
	}

	@XmlElement(name = "wifi")
	public boolean isWifi() {
		return isWifi;
	}

	public void setWifi(boolean isWifi) {
		this.isWifi = isWifi;
	}

	@Override
	public String toString() {
		return "Global_Conf [isUSB=" + isUSB + ", isWifi=" + isWifi + "]";
	}

}
