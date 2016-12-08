package utilities;

import java.io.*;
import java.util.Properties;

public class ConnectionUtils {
    public static void main(String[] args) {

        FileInputStream fileInputStream;
        Properties property = new Properties();
        String path = "config.properties";

            try {
                fileInputStream = new FileInputStream(path);
                property.load(fileInputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
