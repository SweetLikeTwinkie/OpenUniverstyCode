/*
 * @author: Slava Tashlyk
 * @version 19/03/202
 */
import java.util.Scanner;
/*
 * This Class reads from the input the position of a chess Knight on the chessboard and prints all the position on
 * The board to which the Knight can move.
 * 
 */
public class Knight
{
    /*
     * This Method Colculate all position that the knight can move on
     */
    public static void main (String [] args)
    {
        final int BOARD_ROW = 8; // board size 
        final int BOARD_COL = 8; // board size 

        Scanner scan = new Scanner (System.in);

        System.out.println ("This program reads two integers which " +
            "represent the knight's location on the chess board: ");
        
        System.out.println ("Please enter the number of row");
        int row = scan.nextInt(); // scan for position input form user.

        System.out.println ("Please enter the number of column");
        int col = scan.nextInt(); // scan for position input form user.
 
        if ((row > BOARD_ROW || row < 0) || (col > BOARD_COL || col < 0)) // checking if knight position inside the board. 
            System.out.println("input is illegal");
        else 
        {   
            System.out.println("Moves:");
            //(x + 2, y + 1)
            int row1 = row + 2;
            int col1 = col + 1;
            // cheking if new knight position inside the board
            if (row1 > 0 && row1 <= BOARD_ROW && col1 > 0 && col1 <= BOARD_COL) 
                System.out.println(row1 + " " + col1);
            //(x + 1, y + 2)
            int row2 = row + 1;
            int col2 = col + 2;
            if (row2 > 0 && row2 <= BOARD_ROW && col2 > 0 && col2 <= BOARD_COL) 
                System.out.println(row2 + " " + col2);
            //(x – 1, y + 2)
            int row3 = row - 1;
            int col3 = col + 2;
            if (row3 > 0 && row3 <= BOARD_ROW && col3 > 0 && col3 <= BOARD_COL) 
                System.out.println(row3 + " " + col3);
            //(x – 2, y + 1)
            int row4 = row - 2; 
            int col4 = col + 1; 
            if (row4 > 0 && row4 <= BOARD_ROW && col4 > 0 && col4 <= BOARD_COL) 
                System.out.println(row4 + " " + col4);
            //(x – 2, y – 1)
            int row5 = row - 2;
            int col5 = col - 1;
            if (row5 > 0 && row5 <= BOARD_ROW && col5 > 0 && col5 <= BOARD_COL) 
                System.out.println(row5 + " " + col5);
            //(x – 1, y – 2)
            int row6 = row - 1;
            int col6 = col - 2;
            if (row6 > 0 && row6 <= BOARD_ROW && col6 > 0 && col6 <= BOARD_COL) 
                System.out.println(row6 + " " + col6);
            //(x + 1, y – 2)
            int row7 = row + 1;
            int col7 = col - 2;
            if (row7 > 0 && row7 <= BOARD_ROW && col7 > 0 && col7 <= BOARD_COL) 
                System.out.println(row7 + " " + col7);
            //(x + 2, y – 1)
            int row8 = row + 2;
            int col8 = col - 1;
            if (row8 > 0 && row8 <= BOARD_ROW && col8 > 0 && col8 <= BOARD_COL) 
                System.out.println(row8 + " " + col8);
        }
    }
}
