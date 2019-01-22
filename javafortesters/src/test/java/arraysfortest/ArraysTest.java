package arraysfortest;

import dataforconstructor.User;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArraysTest {
    @Test
    public void arrayTest() {
        int [][] array = new int [16][16];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                array[j][i] = i;
                array[i][j] = j;
                System.out.print(array[i][j]+ ",");
            }
            System.out.println();

        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print();
//            }
//            System.out.println(array);
//        }
    }

}
