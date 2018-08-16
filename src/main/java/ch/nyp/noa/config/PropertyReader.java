package ch.nyp.noa.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Loads content of a given property file and parses its string and int values
 *
 * @author Yves Kaufmann
 */
public class PropertyReader {

	private Properties properties;

	/**
	 * @param fileURL
	 */
	public PropertyReader(String fileURL) {
		
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(fileURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Gets the requested property and parses it into a string
	 *
	 * @param propName   Requested property
	 * 
	 * @return Requested property as an integer
	 */
	public int getIntProperty(String propName) {
		
		String propVal = properties.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
		
	}

	/**
	 * Gets the requested property as a string
	 *
	 * @param propName   Requested property
	 * 
	 * @return Requested property as a string
	 */
	public String getStringProperty(String propName) {
		
		String propVal = properties.getProperty(propName);
		return propVal;
		
	}

}
