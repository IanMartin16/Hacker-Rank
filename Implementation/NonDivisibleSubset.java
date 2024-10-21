import java.io.*;
import java.util.*;

class Solution {

    public static int nonDivisibleSubset(int k, List<Integer> S) {
        int[] freq = new int[k];

        // Count the frequency of each remainder when divided by k
        for (int num : S) {
            freq[num % k]++;
        }

        // Initialize result by considering 0 remainder elements
        int result = 0;
        if (freq[0] > 0) {
            result = 1; // We can only take one element with remainder 0
        }

        // Traverse from 1 to k/2 and compare pairs of remainders
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                result += Math.max(freq[i], freq[k - i]);
            } else {
                // If remainder is exactly half of k, we can only take one element
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> S = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
