package com.avianca.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final String CONFIG_PATH="src/test/resources/config.properties";

    public String getValue(String key) throws IOException {
        File file = new File(CONFIG_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public Long getTimeout() throws Exception {
        String timeout = getValue("timeout");
        return Long.parseLong(timeout);
    }
}
