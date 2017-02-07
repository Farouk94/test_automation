package XML_Config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Classe necessaire au traitement des données lu dans le fichier xml
@XmlRootElement(name = "devices")

public class Devices {

	List<Device> devices = null;

	@XmlElement(name = "device")
	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}