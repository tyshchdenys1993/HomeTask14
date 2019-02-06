package com.aqacourses.test.runner;

import com.aqacourses.test.student.StudentMogilyanka;
import com.aqacourses.test.student.StudentNki;
import com.aqacourses.test.student.StudentPedin;

import java.io.IOException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException {

        // Create instance of NKI student
        StudentNki studentNki = new StudentNki();

        // Imagine that GUI opens
        studentNki.openGui();

        // Parse data
        List<String> data = studentNki.parseData();

        // Write data to 'DB'
        studentNki.writeToDb(data);

        // Clear list for reusing
        data.clear();

        // Create instance of Mogilyanka student
        StudentMogilyanka studentMogilyanka = new StudentMogilyanka();

        // Imagine that GUI opens one more time
        studentMogilyanka.openGui();

        // Parse data again
        data = studentMogilyanka.parseData();

        // Write data to another 'DB'
        studentMogilyanka.writeToDb(data);

        // Clear list for reusing
        data.clear();

        StudentPedin studentPedin = new StudentPedin();
        String pathToFile = "D:/AQACourses/FileForParse.txt"; //path to text file
        data = studentPedin.parseFromDb(pathToFile);
        studentPedin.writeToDb(data);
    }
}

