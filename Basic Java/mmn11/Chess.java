/*
 * @author: Slava Tashlyk
 * @version 19/03/2022
 */
import java.util.Scanner;
/*
 * This class take two chessman and their position and colculate via thier movement algorithms
 * if they threat each other.
 */
public class Chess
{
    /*
     * This method gets chessman first name char and thier position on chessboard
     * and calculate if they threat each other and print the result.
     */
    public static void main (String [] args)
    {
        // Board Size
        final int MAX_BOARD_ROW = 8; 
        final int MAX_BOARD_COL = 8; 
        // define new scanner.        
        Scanner scan = new Scanner (System.in); 
        // scan for char input form user.
        System.out.println("Please enter the type"+
                            " of the first chessman");
        char first = scan.next().charAt(0); 
        // scan for int input for first chessman postion.
        System.out.println ("Please enter the number of row");
        int row1 = scan.nextInt(); 
        // scan for int input for first chessman postion.
        System.out.println ("Please enter the number of column");
        int col1 = scan.nextInt(); 
        // scan for char input form user.
        System.out.println("Please enter the type"+
                            " of the second chessman");
        char second = scan.next().charAt(0); 
        // scan for int input for second chessman postion.
        System.out.println ("Please enter the number of row");
        int row2 = scan.nextInt(); 
        // scan for int input for second chessman postion.
        System.out.println ("Please enter the number of column");
        int col2 = scan.nextInt(); 
        // checking if first chessman same as second chessman.
        if (first == second)  
            System.out.println("Chessmen should be different from each other");
        // checking if first chessman position inside the board. 
        else if ((row1 > MAX_BOARD_ROW || row1 < 0) || (col1 > MAX_BOARD_COL || col1 < 0)) 
            System.out.println("Position is not legal");
        // checking if second chessman position inside the board. 
        else if ((row2 > MAX_BOARD_ROW || row2 < 0) || (col2 > MAX_BOARD_COL || col2 < 0)) 
            System.out.println("Position is not legal");
        // checking between postion inputs if they the same.
        else if (row1 == row2 && col1 == col2) 
            System.out.println("Chessmen positions should not be identical");
        else 
        {   
            // Knight logic
            if (first == 'k')  
            {
                //Using Knight movment alogrithem we check if there any other chessman. 
                if ((Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1) || (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2)) 
                {
                    if (second == 'r') // If knihgt threats rook
                        System.out.println("Knight threats rook");
                    else if (second == 'b') // If knihgt threats bishop
                        System.out.println("Knight threats bishop");
                }
                // Using rook movment algorithem we check if rook therets the knight.
                else if ((second == 'r') && ((row2 == row1) || (col2 == col1)))
                {
                    System.out.println("rook threats Knight");
                }
                // Using bishop movment algorithem we check if bishop therets the knight.
                else if ((second == 'b') && (Math.abs(row2 - row1) == Math.abs(col2 - col1)))
                {
                    System.out.println("bishop threats Knight");
                }
                // If no threat
                else
                    System.out.println("no threat");            
            }
            // Rook logic
            else if (first == 'r') 
            {
                // Using rook movment alogrithem we check if there any other chessman. 
                if ((row2 == row1) || (col2 == col1))
                {
                    if (second == 'k') // If rook threats knight
                        System.out.println("rook threats Knight");
                    else if (second == 'b') // if rook threats bishop
                        System.out.println("rook threats bishop");                            
                }
                //Using knight movment algorithem we check if knight therets the rook.
                else if ((second == 'k') && ((Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1) || (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2)))
                {
                    System.out.println("Knight threats rook");
                }
                // Using bishop movment algorithem we check if bishop therets the rook.
                else if ((second == 'b') && (Math.abs(row2 - row1) == Math.abs(col2 - col1)))
                {
                    System.out.println("bishop threats rook");
                }
                // If no threat
                else
                    System.out.println("no threat");
            }
            else
            {
                // Bishop logic
                if (first == 'b') 
                {
                    // Using bishop movment alogrithem we check if there any other chessman. 
                    if (Math.abs(row2 - row1) == Math.abs(col2 - col1))
                    {
                        if (second == 'k') // If bishop threats knight
                            System.out.println("bishop threats Knight");
                        else if (second == 'r') // If bishop threats rook
                            System.out.println("bishop threats rook");                           
                    }
                    // Using knight movment algorithem we check if knight therets the bishop.
                    else if ((second == 'k') && (Math.abs(row2 - row1) == 2 && Math.abs(col2 - col1) == 1) || (Math.abs(row2 - row1) == 1 && Math.abs(col2 - col1) == 2))
                    {
                        System.out.println("Knight threats bishop");
                    }
                    // Using rook movment algorithem we check if rook therets the bishop.
                    else if ((second == 'r') && ((row2 == row1) || (col2 == col1)))
                    {
                            System.out.println("rook threats bishop");
                    }
                    // If no threat
                    else
                        System.out.println("no threat");
                }    
            }
        }
    }
} 