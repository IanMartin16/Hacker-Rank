import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;

        // Find the maximum element of array 'a'
        int maxA = Collections.max(a);

        // Find the minimum element of array 'b'
        int minB = Collections.min(b);

        // Check all numbers from maxA to minB
        for (int num = maxA; num <= minB; num++) {
            boolean factorOfA = true;
            boolean dividesB = true;

            // Check if num is a factor of all elements in array 'b'
            for (int numB : b) {
                if (numB % num != 0) {
                    dividesB = false;
                    break;
                }
            }

            // Check if all elements of array 'a' are factors of num
            for (int numA : a) {
                if (num % numA != 0) {
                    factorOfA = false;
                    break;
                }
            }

            // If num satisfies both conditions, increment count
            if (factorOfA && dividesB) {
                count++;
            }
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
