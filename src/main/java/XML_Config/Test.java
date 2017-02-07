package XML_Config;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

// Classe necessaire au traitement des données lu dans le fichier xml
@XmlRootElement(name = "test")
public class Test implements Comparable<Test> {

	private int level;
	private int number;
	private String name;
	private boolean isUp;

	public Test(int level, int number, String name, boolean isUp) {
		super();
		this.level = level;
		this.number = number;
		this.name = name;
		this.isUp = isUp;
	}

	public Test(int level, int number) {
		super();
		this.level = level;
		this.number = number;
	}

	public Test() {
		super();
	}

	public int getLevel() {
		return level;
	}

	@XmlElement(name = "level")
	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumber() {
		return number;
	}

	@XmlElement(name = "number")

	public void setNumber(int number) {
		this.number = number;
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

	@Override
	public String toString() {
		return "Test [level=" + level + ", number=" + number + ", name=" + name + ", isUp=" + isUp + "]";
	}

	@Override
	public int compareTo(Test o2) {
		if (this.getLevel() < (o2.getLevel())) {

			return -1;
		} else if (this.getLevel() == (o2.getLevel()) & (this.getNumber() < o2.getNumber())) {
			return -1;
		}
		return 0;
	}

}
