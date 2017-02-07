package XML_Config;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Classe necessaire au traitement des données lu dans le fichier xml

@XmlRootElement(name = "level")
public class Level {

	private String name;
	private boolean isUp;
	List<Test> tests = null;

	@XmlElement(name = "test")
	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public boolean isUp() {
		return isUp;
	}

	@XmlAttribute(name = "isUp")
	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	@Override
	public String toString() {
		return "Level [name=" + name + ", isUp=" + isUp + ", tests=" + tests + "]";
	}

	public Level() {
		super();
	}

}
