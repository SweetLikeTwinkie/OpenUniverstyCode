import java.io.*;
import java.util.*;

/** Version 14-02-22 1.0 **/
public class Tester_11
{
    private static int count = 0;
    private static enum tests {TEST_1, TEST_2};
    private static LinkedList<AbstractMap.SimpleEntry<String, String>>  testsList;

    private static void createTest(tests numOfTest) 
    {
        testsList = new LinkedList<AbstractMap.SimpleEntry<String, String>>();

        if(numOfTest == tests.TEST_1)
        {
            testsList.add(new AbstractMap.SimpleEntry<>("5 7", "3 8\n3 6\n4 5\n6 5\n7 6\n7 8")); 
            testsList.add(new AbstractMap.SimpleEntry<>("6 2", "4 1\n4 3\n8 1\n8 3\n5 4\n7 4")); 
            testsList.add(new AbstractMap.SimpleEntry<>("4 5", "2 4\n2 6\n3 3\n3 7\n5 3\n5 7\n6 4\n6 6"));

            testsList.add(new AbstractMap.SimpleEntry<>("1 1", "2 3\n3 2\n"));
            testsList.add(new AbstractMap.SimpleEntry<>("1 8", "3 7\n2 6\n"));
            testsList.add(new AbstractMap.SimpleEntry<>("8 1", "6 2\n7 3\n"));
            testsList.add(new AbstractMap.SimpleEntry<>("8 8", "7 6\n6 7\n"));

            /* ----------------------------- Add more for test 1 here ----------------------------- */

        }
        else if(numOfTest == tests.TEST_2)
        {
            testsList.add(new AbstractMap.SimpleEntry<>("b 2 3 r 5 5", "no threat"));
            testsList.add(new AbstractMap.SimpleEntry<>("b 2 3 r 4 5", "bishop threats rook"));
            testsList.add(new AbstractMap.SimpleEntry<>("k 10 3 r 7 5", "Position is not legal"));

            /* ----------------------------- Add more for test 2 here ----------------------------- */

        }
        else
            System.out.println("Error in createTest number " + numOfTest);

    }

    public static void main(String[] args) 
    {
        System.out.println("------------ BEGIN TEST Q1 ------------");
        runTest(tests.TEST_1);
        System.out.println("------------ End TEST Q1 ------------\n\n");

        System.out.println("------------ BEGIN TEST Q2 ------------");
        runTest(tests.TEST_2);
        System.out.println("------------ End TEST Q2 ------------");
    }

    private static void runTest(tests numOfTest) 
    {
        createTest(numOfTest);
        count = 0;

        for (int i = 0; i < testsList.size(); i++)
            test(testsList.get(i).getKey(),testsList.get(i).getValue(), numOfTest);
    }

    private static void test(String input, String output, tests numOfTest) 
    {
        count++;

        InputStream stdin = System.in;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(b));
        try 
        {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            if (numOfTest == tests.TEST_1)
                Knight.main(new String[] {});
            else if(numOfTest == tests.TEST_2)
                Chess.main(new String[] {});
            else
                System.out.println("Error in test number " + numOfTest);
        } catch (Exception e) 
        {
            System.out.println("Error!!!\n" + e.getMessage());
        }
        finally 
        {
            System.setIn(stdin);
            System.out.flush();
            System.setOut(old);
        }

        String outputStudent = b.toString();

        if (match(outputStudent, output, numOfTest))
        {
            System.out.printf("%s %30s\n","Test #" + count, "\t\tPassed");
        }
        else
        {
            System.out.printf("\n%s %30s","Test #" + count, "\t\tFAILED!!!!\n");
            System.out.println("Input is:\n" + input);
            System.out.println("Student's output is:\n" + outputStudent);
            System.out.println("Output should contain:\n" + output);
        }
    }

    private static boolean match(String result, String ans, tests numOfTest) {
        if (numOfTest == tests.TEST_1) {
            result = result.replace("\r", "");
            result = result.substring(result.lastIndexOf(":") + 2);

            String[] resultArr = result.split("\n");
            String[] ansArr = ans.split("\n");

            if (resultArr.length != ansArr.length)
                return false;

            Arrays.sort(resultArr);
            Arrays.sort(ansArr);

            for (int i = 0; i < resultArr.length; i++) {
                if (!resultArr[i].equals(ansArr[i]))
                    return false;
            }
            return true;
        }
        else if (numOfTest == tests.TEST_2) {
            if (result.contains(ans))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}