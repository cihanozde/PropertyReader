package util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by cihanozdemir on 12.11.2017.
 */
public class ConfigurationInstance {
    private static ConfigurationInstance instance = null;
    private Properties properties = new Properties();

    public static ConfigurationInstance getInstance(String environment) {
        if (instance == null) {
            instance = new ConfigurationInstance();
//            instance.loadConfigProperties();
        }
        return instance;
    }

    public String loadConfigProperties(String fileName, String fieldName) {
        try {
            FileInputStream input = new FileInputStream(fileName);
            this.properties.load(input);
            return properties.getProperty(fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
