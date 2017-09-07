package com.example.codinggridexample;

import com.example.codinggridexample.shortestpath.MinCostPath;

import org.junit.Test;

import static android.os.Build.VERSION_CODES.M;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MinCostPathTest {
    //sample 13
    @Test
    public void normalMatrixTest_sample13() {
        //Arrange
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 20;
        String expectedsmallestPath = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

    //sample 2
    @Test
    public void normalMatrixTest_sample2() {
        //Arrange
        int[][] matrix = {
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 2, 3, 6},
                {3, 7, 2, 1, 2, 3}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 11;
        String expectedsmallestPath = "1 2 1 5 5 5";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

    //sample 1
    @Test
    public void normalMatrixTest_sample1() {
        //Arrange
        int[][] matrix = {
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 15;
        String expectedsmallestPath = "3 2 4 2 4 2";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }


    //sample 8
    @Test
    public void normalMatrixTest_sample8() {
        //Arrange
        int[][] matrix = {
                {69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = false;
        int expectedTotalPath = 0;
        String expectedsmallestPath = "";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

    //sample 5
    @Test
    public void normalMatrixTest_sample5() {
        //Arrange
        int[][] matrix = {
                {5},
                {8},
                {5},
                {3},
                {5}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 3;
        String expectedsmallestPath = "4";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }


    //sample 9
    @Test
    public void normalMatrixTest_sample9() {
        //Arrange
        int[][] matrix = {
                {60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 14;
        String expectedsmallestPath = "3 1 1 3";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

    //Sample 10
    @Test
    public void normalMatrixTest_sample10() {
        //Arrange
        int[][] matrix = {
                {6, 3, -5, 9},
                {-5, 2, 4, 10},
                {3, -2, 6, 10},
                {6, -1, -2, 10}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = -3;
        String expectedsmallestPath = "2 3 1 1";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

    //sample 11
    @Test
    public void normalMatrixTest_sample11() {
        //Arrange
        int[][] matrix = {
                {51, 51},
                {0, 51},
                {51, 51},
                {5, 5}
        };
        MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 10;
        String expectedsmallestPath = "4 4";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }


    //sample 7
    @Test
    public void normalMatrixTest_sample7(){
        //Arrange
        int[][] matrix = {
                { }
        };
       MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = false;
        int expectedTotalPath = 0;
        String expectedsmallestPath = "";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

    //sample 12
    @Test
    public void normalMatrixTest_sample12(){
    //Arrange
    int[][] matrix = {
     {51,51,51},
    {0,51,51},
    {51,51,51},
    {5,5,51}
     };
    MinCostPath matrixClass = new MinCostPath();

    //Act
       matrixClass.normalMatrix(matrix);

//        //Assert
      boolean expectedreachedTarget = false;
        int expectedTotalPath = 0;
        String expectedsmallestPath ="";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }


    //sample 4
    @Test
   public void normalMatrixTest_sample4(){
       //Arrange
        int[][] matrix = {
               {5,8,5,3,5},
        };
     //this test case is not working due the code is adding up new row in the matrix and its making running new internal calls

       MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

        //Assert
        boolean expectedreachedTarget = true;
        int expectedTotalPath = 26;
        String expectedsmallestPath = "1 1 1 1 1";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

   //sample 6
   @Test(expected = NumberFormatException.class)
    public void normalMatrixTest_sample6() {
       //Arrange
       String inputData = "5,4,H;8,M,7;5,7,5";

       MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(inputData);

        //Assert
       //throws exception
    }

    //Sample 3
    @Test
    public void normalMatrixTest_sample3(){
       //Arrange
        int[][] matrix = {
                {19, 10, 19, 10, 19},
               {21, 23, 20, 19, 12},
               {20, 12, 20 ,11, 10}
        };
       MinCostPath matrixClass = new MinCostPath();

        //Act
        matrixClass.normalMatrix(matrix);

       //Assert
        boolean expectedreachedTarget = false;
        int expectedTotalPath = 0;
       String expectedsmallestPath = "";
        assertEquals(expectedreachedTarget, matrixClass.reachedTarget);
        assertEquals(expectedTotalPath, matrixClass.totalPath);
        System.out.println(matrixClass.totalPath);
        assertEquals(expectedsmallestPath, matrixClass.smallestPath);
    }

}

