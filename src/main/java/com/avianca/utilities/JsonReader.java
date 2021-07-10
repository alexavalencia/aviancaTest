package com.avianca.utilities;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    private final Logger LOG = LoggerFactory.getLogger(JsonReader.class);

    public <T> List<T> getObjects(String filePath, Class classT) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            Gson gson = new Gson();
            T[] list = (T[]) gson.fromJson(br, classT);
            return  Arrays.asList(list);

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return new ArrayList<>();
    }

}
