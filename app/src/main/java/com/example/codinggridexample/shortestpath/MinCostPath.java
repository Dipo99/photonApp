package com.example.codinggridexample.shortestpath;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class MinCostPath {

    private static int overflowConstant = 100;
    private static int maxCost = 50;
    HashMap<String, Integer> routePath = new LinkedHashMap<String, Integer>();
    String smallest = new String();
    String newKey = new String();
    int newValue = 0;
    int previousValue = 0;
    public String smallestPath = "";
    public int totalPath = 0;
    public boolean reachedTarget = false;
    public boolean enableLogs = false;

    private static MinCostAndPath minCostAndPath(int grid[][]) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int minCost[][] = new int[numRows][numCols];
        String minPath[][] = new String[numRows][numCols];

        int minTillNow = Integer.MAX_VALUE;
        int minX = 0;

        for (int x = 0; x < numRows ; x++) {
            int minNow = minCostAndPathHelper(grid, minCost, minPath, x, numCols - 1);
            if (minNow < minTillNow) {
                minTillNow = minNow;
                minX = x;
            }
        }

        boolean canCross = true;
        if (minTillNow >= overflowConstant) {
            canCross = false;
            minTillNow = minTillNow - overflowConstant;
        }

        return new MinCostAndPath(canCross, minTillNow, minPath[minX][numCols - 1]);
    }   
 
    private static int minCostAndPathHelper(int grid[][], int minCost[][], String minPath[][], int x, int y) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        if (y == 0) {
            minCost[x][y] = grid[x][y];
            minPath[x][y] = "" + (x + 1);
            if (grid[x][y] > maxCost) {
                minCost[x][y] = overflowConstant;
                minPath[x][y] = "";
            }
            
            return minCost[x][y];
        }

        if (minPath[x][y] != null) {
            return minCost[x][y];
        }

        int xUp = x - 1, xDown = x + 1;
        if (xUp < 0) {
            xUp = numRows - 1;
        }
        if (xDown == numRows) {
            xDown = 0;
        }
        int minUp = minCostAndPathHelper(grid, minCost, minPath, xUp, y - 1),
            minSame = minCostAndPathHelper(grid, minCost, minPath, x, y - 1),
            minDown = minCostAndPathHelper(grid, minCost, minPath, xDown, y - 1);

        ArrayList<Integer> mins = new ArrayList<>(Arrays.asList(minUp, minSame, minDown));
        int xs[] = { xUp, x, xDown };
        int minNext = Math.min(Math.min(minUp, minSame), minDown);
        int xNext = xs[mins.indexOf((Integer)minNext)];

        if (minNext >= overflowConstant) {
            minCost[x][y] = minNext;
            minPath[x][y] = minPath[xNext][y - 1];
        }
        else if (minNext + grid[x][y] > maxCost) {
            minCost[x][y] = minNext + overflowConstant;
            minPath[x][y] = minPath[xNext][y - 1];
        }
        else {
            minCost[x][y] = minNext + grid[x][y];
            minPath[x][y] = minPath[xNext][y - 1] + " " + (x + 1);
        }

        return minCost[x][y];
    }
 
    /*public static void main(String args[])
    {
         int grid[][]= {{3, 4, 1, 2, 8, 6},
                        {6, 1, 8, 2, 7, 4},
                        {5, 9, 3, 9, 9, 5},
                        {8, 4, 1, 3, 2, 6},
                        {3, 7, 2, 8, 6, 4}};

        // int grid[][]= {{3, 4, 1, 2, 8, 6},
        //                {6, 1, 8, 2, 7, 4},
        //                {5, 9, 3, 9, 9, 5},
        //                {8, 4, 1, 3, 2, 6},
        //                {3, 7, 2, 1, 3, 3}};

        // int grid[][]= {{19, 10, 19, 10, 19},
        //                {21, 23, 20, 19, 12},
        //                {20, 12, 20, 11, 10}};
       // int grid[][] = {{51}};

        MinCostAndPath minCostObj = minCostAndPath(grid);
        if (minCostObj.canCross) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        System.out.println(minCostObj.cost);
        System.out.println(minCostObj.path);
    }*/

 /*   public String printMatrix(String input) {
        String print = "";
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (j == input[i].length - 1) {
                    print = print.concat(String.valueOf(input[i][j]));
                } else {
                    print = print.concat(String.valueOf(input[i][j]).concat(" "));
                }
            }
            print = print.concat("\n");
        }
        return print;
    }*/

    public int[][] createMatrix(String input) {
        Log.i("inside ....","inside createMatrixmethod....");
        String[] rows = input.trim().split(";");
        int rowsLength = rows.length;
        String[] cols = rows[0].trim().split(",");
        int colsLength = cols.length;
        int[][] matrix = new int[rowsLength][colsLength];
        for (int i = 0; i < rows.length; i++) {
            String[] forEachRow = rows[i].trim().split(",");
            for (int j = 0; j < forEachRow.length; j++) {
                matrix[i][j] = Integer.parseInt(forEachRow[j]);
            }
        }
        return matrix;
    }

    public String normalMatrix(String input){
        if(enableLogs)
            Log.i("inside normalMatrix....","inside normalMatrix....");
        int[][] matrix = createMatrix(input);
        routePath = new HashMap<String,Integer>();
        if(enableLogs)
            Log.d("dimensions...",matrix.length+"");
        for(int i=0;i<matrix.length;i++) {
            if(enableLogs)
                Log.d("looping...",i+"");
            routePath = shortestPath(matrix, i, 0, "");
        }
        return displayFormat(routePath,matrix);
    }

    public String normalMatrix(int[][] matrix){
        if(enableLogs)
            Log.i("inside normalMatrix....","inside normalMatrix....");
        routePath = new HashMap<String,Integer>();
        if(enableLogs)
            Log.d("dimensions...",matrix.length+"");
        for(int i=0;i<matrix.length;i++) {
            if(enableLogs)
                Log.d("looping...",i+"");
            routePath = shortestPath(matrix, i, 0, "");
        }
        return displayFormat(routePath,matrix);
    }

    private HashMap<String,Integer> shortestPath(int[][] input, int row, int col, String key) {
        if(enableLogs)
            Log.i("inside shortestPath....","inside shortestPath....");
        for (int i = col; i < input[0].length; i++) {
            if (col == 0) {
                smallest="";
                newKey = "";
                newValue=0;
                previousValue=0;
            } else {
                if (row == 0) {
                    smallest = smallestValue(input[input.length - 1][col], input[row][col], input[row + 1][col]);
                    if (smallest.equals("first")) {
                        newKey = String.valueOf(input.length);
                        newValue = input[input.length - 1][col];
                    } else if (smallest.equals("second")) {
                        newKey = String.valueOf(row + 1);
                        newValue = input[row][col];
                    } else if (smallest.equals("third")) {
                        newKey = String.valueOf(row + 2);
                        newValue = input[row + 1][col];
                    }
                } else if (row == input.length - 1) {
                    smallest = smallestValue(input[row - 1][col], input[row][col], input[0][col]);
                    if (smallest.equals("first")) {
                        newKey = String.valueOf(row);
                        newValue = input[row - 1][col];
                    } else if (smallest.equals("second")) {
                        newKey = String.valueOf(row + 1);
                        newValue = input[row][col];
                    } else if (smallest.equals("third")) {
                        newKey = String.valueOf(1);
                        newValue = input[0][col];
                    }
                } else {
                    smallest = smallestValue(input[row - 1][col], input[row][col], input[row + 1][col]);
                    if (smallest.equals("first")) {
                        newKey = String.valueOf(row);
                        newValue = input[row - 1][col];
                    } else if (smallest.equals("second")) {
                        newKey = String.valueOf(row + 1);
                        newValue = input[row][col];
                    } else if (smallest.equals("third")) {
                        newKey = String.valueOf(row + 2);
                        newValue = input[row + 1][col];
                    }
                }
            }

            if (routePath.get(key) != null) {
                previousValue = routePath.get(key);
            } else {
                previousValue = input[row][col];
            }
            if (key.equals("")) {
                key = key.concat(String.valueOf(row + 1).concat(" "));
                if(previousValue+newValue>50){
                    return routePath;
                }
                routePath.put(key, previousValue + newValue);
            } else {
                routePath.remove(key);
                key = key.concat(String.valueOf(newKey).concat(" "));
                if(previousValue+newValue>50){
                    return routePath;
                }
                routePath.put(key, previousValue + newValue);
                //}
            }

            if (++col < (input[0].length) - 1) {
                if(enableLogs)
                    Log.i("inside...","if block");
                return shortestPath(input, row, col, key);
            }
        }
        if(enableLogs)
            Log.i("end....","inside end of  shortestPath....");
        return routePath;
    }

    public String smallestValue(int a, int b, int c) {
        //System.out.println(a+"  "+b+"   "+c);
        if(enableLogs)
            Log.i("inside ....","inside displayFormat....");
        if (a < b) {
            if (a < c) {
                return "first";
            } else {
                return "third";
            }
        } else {
            if (b < c) {
                return "second";
            } else {
                return "third";
            }
        }
    }
    public String displayFormat(HashMap<String, Integer> listOfRoutes, int[][] matrix) {
        if(enableLogs)
            Log.i("inside ....","inside displayFormat....");

        if (listOfRoutes == null) {
            return "No\n" + totalPath + "\n" + "[" + smallestPath + "]";
        } else {
            totalPath =50;
            for (String temp : listOfRoutes.keySet()) {
                if (listOfRoutes.size() == 1) {
                    totalPath = listOfRoutes.get(temp);
                    smallestPath = temp.trim();
                }
                if (listOfRoutes.get(temp) <= totalPath) {
                    totalPath = listOfRoutes.get(temp);
                    smallestPath = temp.trim();
                }
            }
//            System.out.println(reachedTarget);
//            System.out.println(smallestPath);
//            System.out.println(matrix[0].length);
//            System.out.println(smallestPath.trim().split(" ").length );
            if (smallestPath.trim().split(" ").length == matrix[0].length) {
                reachedTarget = true;
            }
            if (reachedTarget == true) {
                return "Yes\n" + totalPath + "\n" + "[" + smallestPath + "]";
            } else {
                totalPath = 0;
                return "No\n" + totalPath + "\n" + "[" + smallestPath + "]";
            }
        }

    }

    public String shortestPathforColMatrix(String input) {
        int[][] matrix = createMatrix(input);

        int small = matrix[0][0];
        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k][0] < small) {
                small = matrix[k][0];
                newKey = String.valueOf((k + 1));
                newValue = matrix[k][0];
                routePath.put(newKey, newValue);
            }

        }
        return displayFormat(routePath, matrix);
    }

    public String shortestPathforRowMatrix(String input) {

        int[][] matrix = createMatrix(input);
        String rowKey = String.valueOf(matrix.length);
        int rowValue = 0;
        for (int k = 0; k < matrix[0].length; k++) {
            if (routePath.get(rowKey) != null) {
                rowValue = routePath.get(rowKey) + matrix[0][k];
                //routePath.remove(rowKey);
                if (rowValue > 50) {
                    rowValue = rowValue - matrix[0][k];
                    return displayFormat(routePath, matrix);
                }
                rowKey = rowKey.concat((" ").concat(String.valueOf(matrix.length)));
            } else {
                rowValue = matrix[0][k];
            }
            routePath.clear();
            routePath.put(rowKey, rowValue);
        }
        return displayFormat(routePath, matrix);
    }

    public String negativeValuedMatrixShortestPath(String input){
        int[][] matrix = createMatrix(input);
        routePath = new HashMap<String,Integer>();
        for(int i=0;i<matrix.length;i++) {
            routePath = shortestPath(matrix, i, 0, "");
        }
        return displayFormat(routePath,matrix);
    }

    public String largeNumberOfColumns(String input){
        int[][] matrix = createMatrix(input);
        routePath = new HashMap<String,Integer>();
        for(int i=0;i<matrix.length;i++) {
            routePath = shortestPath(matrix, i, 0, "");
        }
        return displayFormat(routePath,matrix);
    }

    public String firstElementsAboveFifty(String input) {
        int[][] matrix = createMatrix(input);
        int firstElement = 0;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] > 50) {
                ++firstElement;
            }
        }
        if(firstElement==matrix.length){
            routePath = null;
        }
        return displayFormat(routePath, matrix);
    }

    public String oneValueAboveFifty(String input) {
        int[][] matrix = createMatrix(input);
        routePath = new HashMap<String,Integer>();
        for(int i=0;i<matrix.length;i++) {
            routePath = shortestPath(matrix, i, 0, "");
        }
        return displayFormat(routePath,matrix);
    }

    public String noInputMatrix(String input){
        if(input=="")
            return "Invalid Matrix";
        else
            return normalMatrix(input);
    }
}