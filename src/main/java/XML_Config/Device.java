package XML_Config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * Classe necessaire au traitement des données lu dans le fichier xml
 */

@XmlRootElement(name = "device")

public class Device {
	private String name;
	private String usb_id;
	private String wifi_id;
	private boolean isUp;

	public String getUsb_id() {
		return usb_id;
	}

	@XmlElement(name = "usb_id")

	public void setUsb_id(String usb_id) {
		this.usb_id = usb_id;
	}

	public String getWifi_id() {
		return wifi_id;
	}

	@XmlElement(name = "wifi_id")

	public void setWifi_id(String wifi_id) {
		this.wifi_id = wifi_id;
	}

	public Device(String name, String usb_id, String wifi_id, boolean isUp) {
		super();
		this.name = name;
		this.usb_id = usb_id;
		this.wifi_id = wifi_id;
		this.isUp = isUp;
	}

	@Override
	public String toString() {
		return "Device [name=" + name + ", usb_id=" + usb_id + ", wifi_id=" + wifi_id + ", isUp=" + isUp + "]";
	}

	public Device() {
		super();
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUp() {
		return isUp;
	}

	@XmlElement(name = "isUp")

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

}
