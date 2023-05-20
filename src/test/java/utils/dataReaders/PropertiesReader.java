package utils.dataReaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static Properties pathsData;
    public static Properties driverTypeData;

    static {
        try {
            pathsData = loadProperties(System.getProperty("user.dir")+"//src//main//resources//properties/paths.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
    }

    static {
        try {
            driverTypeData = loadProperties(System.getProperty("user.dir")+"//src//main//resources//properties/driverType.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
    }



    private static Properties loadProperties(String path) throws FileNotFoundException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(path);
        try {
            pro.load(fis);
        } catch (IOException e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
            return pro;
    }
}
