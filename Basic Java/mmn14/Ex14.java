/**
 *  This class is the answer to Exercise 14 at the course.
 * 
 * 
 *  - Answers to Question 1 Section 1:
 *      1. False.
 *      2. False.
 *      3. True.
 *      4. False.
 *      5. True.
 *      6. True.
 * 
 * @author Slava Tashlyk
 * @version 25/05/2022
 */
public class Ex14
{
    /**
     * This method gets a multidimensional arry(m[][]) and number(val) that the method searching in the array if it exist.
     * If exist return true, if not return false.
     * Works only if method what returned true!.         
     * 
     * What method explanstion on matrix:
     * 
     * O < O < O < O
     * ^   ^   ^   ^
     * O < O < O < O
     * ^   ^   ^   ^
     * O < O < O < O
     * 
     * - Time complexity  - O(n) - One loop for search in array rows.
     * - Space complexity - O(1) - All vars are constant.
     * 
     * @param m[][] - Multidimensional array to che.
     * @param val - Number for search.
     * @return - True/False if val found or not found in the array.
     */
    public static boolean findValWhat(int [][]m,int val)
    {        
        int row = 0; // Set the row to 0.
        int column = m[row].length - 1; // Set the column to the last index in the array.
        while (row < m.length && column >= 0)  // Run over the arrays rows.
        {
            if (m[row][column] == val) // If the array object equal to the object at the last column in the row.
            {
                return true; // Val found.
            }
            if (m[row][column] < val) // If the array object less than val we move to the next row.
            {
                row++; // Move to the next row.
            }
            else // If the array object more then the object in the last column we move to the next column.
            {
                column--; // Move to the next column.
            }
        }
        return false; // Val not found.
    }

    /**
     * This method gets a multidimensional arry(m[][]) and number(val) that the method searching in the array if it exist.
     * If exist return true, if not return false.
     * Works only if method Test returned true!.         
     * 
     * - Time complexity  - In worst case it will be O(n^2) otherwise it will be O(n). -
     * - Space complexity - O(1) - All vars are constant.
     *  
     * @param m[][] - Multidimensional array.
     * @param val - Number for search.
     * @return - True/False if val found or not found in the array.
     */
    public static boolean findValTest(int[][] m, int val)
    {
        int row = -1; // Var to save the row number outside the loop.
        int i = 0; // Var to save amount of iteration outside the loop.
        while (i < m.length) // Run over the arrays rows. 
        {
            if (m[i][0] >= val) // If the first object in the row equal or more then val.
            {
                row = i; // Save the row number.
            }
            i += 1; // Increase to iteration count.
        }
        if (row == -1) // If the first object in the row  not equal or more then val.
        {
            row = m.length - 1; // Set row to the last row.
        }
        while (row >= 0) // If found any row that match to test method alogrithm.
        {
            for (int j = 0; j < m.length; ++j) // Run over the arrays columns. 
            {
                if (m[row][j] == val) // 
                {
                    return true; // Val found.
                }
            }
            row -= 1; // Decrease row number.
        }
        return false; // Val not found.
    }

    /**
     * This method get the array as parameter and return the amount of sub-arrays that arranged in 
     * ascending order.
     * 
     * Example: 
     * int[] a = {1, 2, 4, 4, 5}; | We have 4 sub-arrays | {1,2} {1,2,4} {2,4} {4,5}.
     * int[] a = {1, 3, 2}; | We have 1 sub-array | {1,3}.
     * int[] a = {5, 4, 3, 2, 1}; | We have 0 sub-arrays.
     * 
     * 
     * - Time complexity - O(n^2)
     * - Space complexity - O(1)
     *
     * @param a[] - array.
     * @return - count of sub-arrays.
     */
    public static int strictlyIncreasing (int[] a)
    {   
        int count = 0; // Set Count to 0.
        for (int i = 0; i < a.length; i++) // Run over the flat array objects.
        {
            for (int j = i + 1; j < a.length; j++) // Run over the next object of the flat array.
            {
                if (a[j] > a[j-1]) // If the second scaned object in the array less than the first.
                {
                    ++count; // Add 1 to the count.
                }
                else // If not
                {
                    break; // Stop the second loop run.
                }
            }
        }
        return count; // Return the count.
    }
    /**
     * This method get the array as parameter and return longest flat sub array.
     * 
     * @param arr[] - array.
     * @return - Sub array length.
     */
    public static int longestFlatSequence (int[] arr)
    {
        return lengthFlat(arr, 0, 0, 0);
    }  
    /*
     * This method get the array as parameter and return longest flat sub array.
     * 
     * 
     * @param rra[] - array.
     * @longestSeq - The length of the longest seq.
     * @sequence 
     * @return - Sub array length.
     */
    private static int lengthFlat(int[] arr, int index, int longestSeq, int sequence)
    {
        if(index <= 0) 
        {
            index = 1;
        }        
        if(index >= arr.length) 
        {
            return longestSeq + 1;
        }
        if(arr[index] > arr[index - 1])
        {
            sequence++;
            if(sequence > longestSeq) 
            {
                longestSeq = sequence;
            }
        }
        else
        {
            sequence = 0;
        }
        return lengthFlat(arr, ++index, longestSeq, sequence);
    }

    /**
     *  This overloaded method returns the maximum amount of points that can be reached in any trajectory in 
     *  the two-dimensional array(mat[][]) with starting point at mat[0][0].
     * 
     * @param mat[][] - Input multidimensional arry.
     * @return - Maximum amount of points, If -1 return: -1 cell at starting point.
     */
    public static int findMaximum(int[][] mat)
    {
        return findMaximum(mat,0,0); // Call the private metheod with starting point at [0][0].
    }

    /*
     *  This private recursive method the colculate and returns the maximum amount of points that can be reached 
     *  in any trajectory in the two-dimensional array(mat[][]) with starting point at mat[0][0].
     * 
     *  The rules:
     *  -   We have matrix where each cell/object have value of 1 / 0 / -1.
     *  -   -1 is unavaliable to move on.
     *  -   We need to collect the maximum point where 1 = 1 Point / 0 = 0 Points.
     *  -   We can only go left or down if the row is odd.
     *  -   we can only go right or down if the row is even.
     * 
     * @param mat[][] - Input multidimensional arry.
     * @param row - Corrent row.
     * @param col - Corrent Column.
     * @return - Maximum amount of points, If -1 return: -1 cell at starting point.
     */
    private static int findMaximum(int[][] mat, int row, int col)
    {
        if (mat[0][0] == -1) // Check if the object at starting position equals -1.
        {
            return -1; // return as asked in the exercise.
        }
        if (!isSafe(mat, row, col)) // Check if we can move to another cell.
        {
            return 0; // If we cant move to the next cell return 0
        }
        if ((row & 1) == 1) // Check if the row is odd.
        {
            // Check and move to the next cell.
            return mat[row][col] + Math.max(findMaximum(mat, row, col - 1), findMaximum(mat, row + 1, col));
        }
        else // Check if the row is even.
        {
            // Check and move to the next cell. 
            return mat[row][col] + Math.max(findMaximum(mat, row, col + 1), findMaximum(mat, row + 1, col));
        }
    }

    /*
     *  This is private method that helps to check if the next cells avaliable to move.
     *
     * @param mat[][] - Input multidimensional arry.
     * @param row - Corrent row.
     * @param col - Corrent Column.
     * @return - True if there avaliable movment False if not.
     */
    private static boolean isSafe(int[][] mat, int row, int col)
    {
        return !(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == -1);
    }

}
