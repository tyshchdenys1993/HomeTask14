package com.aqacourses.cucumber.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class YamlParser {

    /**
     * Method for parsing yaml file
     *
     * @return
     */
    public static YamlFile getYamlData() {
        YamlFile yamlFile = null;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            yamlFile =
                    objectMapper.readValue(
                            new File("src/main/resources/configuration.yaml"), YamlFile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return yamlFile;
    }
}
