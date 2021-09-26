package com.epam.tc.hw6.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class TestUtils {
    private static String propertiesFilename = "test.properties";
    private static String username = "";
    private static String pass = "";
    private static String loggedInUsername = "";


    static {
        try {
            try (InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(propertiesFilename)) {
                Properties properties = new Properties();
                if (inputStream != null) {
                    properties.load(inputStream);
                } else {
                    throw new FileNotFoundException(
                        "property file '" + propertiesFilename + "' not found in the classpath");
                }
                username = properties.getProperty("user");
                pass = properties.getProperty("password");
                loggedInUsername = properties.getProperty("loggedInUsername");
            }
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

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }
}
