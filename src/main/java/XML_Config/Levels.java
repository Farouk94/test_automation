package XML_Config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Classe necessaire au traitement des données lu dans le fichier xml
@XmlRootElement(name = "levels")
public class Levels {
	List<Level> levels = null;

	public List<Level> getLevels() {
		return levels;
	}

	@XmlElement(name = "level")
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

}
