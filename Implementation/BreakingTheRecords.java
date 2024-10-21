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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Initialize variables to keep track of maximum and minimum scores
        int maxScore = scores.get(0);
        int minScore = scores.get(0);

        // Initialize variables to count the number of times records are broken
        int maxRecordCount = 0;
        int minRecordCount = 0;

        // Iterate through the scores starting from the second game
        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            // If the current score is greater than the maximum score so far, update maximum score and increment maxRecordCount
            if (score > maxScore) {
                maxScore = score;
                maxRecordCount++;
            }
            // If the current score is less than the minimum score so far, update minimum score and increment minRecordCount
            if (score < minScore) {
                minScore = score;
                minRecordCount++;
            }
        }

        // Return the counts of breaking the maximum and minimum records
        List<Integer> recordsBroken = new ArrayList<>();
        recordsBroken.add(maxRecordCount);
        recordsBroken.add(minRecordCount);
        return recordsBroken;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
