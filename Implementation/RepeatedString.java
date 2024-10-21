import java.io.*;
import java.util.*;

class Solution {

    public static long repeatedString(String s, long n) {
        // Count occurrences of 'a' in the string s
        long countAInS = s.chars().filter(ch -> ch == 'a').count();
        
        // Number of complete repetitions of s within n characters
        long completeRepetitions = n / s.length();
        
        // Remaining characters after complete repetitions
        long remainingCharacters = n % s.length();
        
        // Count 'a's in the remaining characters
        long countAInRemaining = s.substring(0, (int) remainingCharacters).chars().filter(ch -> ch == 'a').count();
        
        // Total count of 'a's in the first n characters
        long totalCountA = (countAInS * completeRepetitions) + countAInRemaining;
        
        return totalCountA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();
        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
