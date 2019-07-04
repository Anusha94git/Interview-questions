package in.keys2javaselenium.newtours1.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonLibrary {

	public static String getPropertyValue(String key, String fileName) throws IOException {

		FileInputStream fis = 
				new FileInputStream("\\TestData\\" + 
						fileName + ".properties");

		Properties p = new Properties();
		p.load(fis);

		return p.getProperty(key);

	}
}
