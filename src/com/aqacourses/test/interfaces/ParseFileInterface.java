package com.aqacourses.test.interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface ParseFileInterface {

    /**
     * Parse from existing DB
     *
     * @param pathToFile
     * @return
     */

    ArrayList <String> parseFromDb(String pathToFile) throws IOException;
}
