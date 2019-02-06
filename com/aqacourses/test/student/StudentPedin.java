package com.aqacourses.test.student;

import com.aqacourses.test.interfaces.ParseFileInterface;
import com.aqacourses.test.interfaces.WriteToDbInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentPedin extends Student implements WriteToDbInterface, ParseFileInterface {

    private File file;
    private BufferedWriter bufferedWriter;

    /**
     * Parse student name, age and sex from text file in ArrayList
     *
     * @param pathToFile
     * @return
     * @throws IOException
     */

    @Override
    public ArrayList<String> parseFromDb(String pathToFile) throws IOException {

        ArrayList<String> parsedData = new ArrayList<>();
        File parsedFile = new File(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(parsedFile));
        String line = null;

        while((line = bufferedReader.readLine())!= null){
            parsedData.add(line);
        }
        bufferedReader.close();

        return parsedData;
    }

    /**
     * Write student to MS-SQL DB
     *
     * @param data
     */

    @Override
    public void writeToDb(List<String> data) {
        try {
            openConnection();
            if (isParsedDataValid(data)) {
                for (String datum : data) {
                    bufferedWriter.write(getDate() + " - " + datum);
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("==================\n");
                System.out.println("All data is written to MS SQL DB succesfully");
                closeConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open connection to MS SQL DB
     */
    private void openConnection() throws IOException {
        String path = "D:/AQACourses/MS-SQL-DB.txt";
        file = new File(path);
        bufferedWriter = new BufferedWriter(new FileWriter(file, true));
    }

    /**
     * Close connection to MS SQL DB
     */
    private void closeConnection() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Cannot close connection to MS SQL DB");
            e.printStackTrace();
        }
        System.out.println("Close connection to MS SQL DB");
    }
}
