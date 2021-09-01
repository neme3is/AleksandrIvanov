package com.epam.tc.hw3.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class TestUtils {
    private static String username = "";
    private static String pass = "";

    static {
        try {
            Properties properties = new Properties();
            String propertiesFilename = "test.properties";
            InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(propertiesFilename);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException(
                    "property file '" + propertiesFilename + "' not found in the classpath");
            }
            username = properties.getProperty("user");
            pass = properties.getProperty("password");
            inputStream.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static String getUsername() {
        return username;
    }

    public static String getPass() {
        return pass;
    }

}
