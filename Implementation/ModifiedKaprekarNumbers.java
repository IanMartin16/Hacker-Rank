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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        List<Integer> kaprekarNumbersList = new ArrayList<>();
        
        for(int i = p; i <= q; i++) {
            long squared = (long) i * i;
            String squaredStr = String.valueOf(squared);
            int d = String.valueOf(i).length();
            
            String rightStr = squaredStr.length() > d ? squaredStr.substring(squaredStr.length() - d) : squaredStr;
            String leftStr = squaredStr.length() > d ? squaredStr.substring(0, squaredStr.length() - d) : "0";
            
            int left = Integer.parseInt(leftStr);
            int right = Integer.parseInt(rightStr);
            
            if(left + right == i) {
                kaprekarNumbersList.add(i);
            }
        }
        if(kaprekarNumbersList.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            for(int num : kaprekarNumbersList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}