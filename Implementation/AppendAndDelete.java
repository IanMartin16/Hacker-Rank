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
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Step 1: Find the length of the common prefix
        int commonLength = 0;
        int minLength = Math.min(s.length(), t.length());
        
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        // Step 2: Calculate the number of operations needed
        int totalOperationsNeeded = (s.length() - commonLength) + (t.length() - commonLength);
        
        // Step 3: Determine if we can do exactly k operations
        if (totalOperationsNeeded == k) {
            return "Yes";
        } else if (totalOperationsNeeded < k) {
            // If we have more operations than needed, check if we can make the exact number by 
            // adding unnecessary operations (like deleting from an empty string)
            if ((k - totalOperationsNeeded) % 2 == 0 || (s.length() + t.length()) <= k) {
                return "Yes";
            } else {
                return "No";
            }
        } else {
            return "No";
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
