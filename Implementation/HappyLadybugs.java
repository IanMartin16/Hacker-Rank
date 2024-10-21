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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    if (areLadybugsHappy(b)) {
            return "YES";
        }

        
        Map<Character, Integer> freqMap = new HashMap<>();
        boolean hasEmptySpace = false;

        for (char c : b.toCharArray()) {
            if (c == '_') {
                hasEmptySpace = true;  
            } else {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1); 
            }
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return "NO";
            }
        }

        return hasEmptySpace ? "YES" : "NO";
    }

    private static boolean areLadybugsHappy(String b) {
        int n = b.length();
        for (int i = 0; i < n; i++) {
            char current = b.charAt(i);
            
            if (current != '_') {
                boolean leftSame = (i > 0 && b.charAt(i - 1) == current);  
                boolean rightSame = (i < n - 1 && b.charAt(i + 1) == current); 

                if (!leftSame && !rightSame) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}