import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        int n = topic.size();
        int maxTopics = 0;
        int maxTeams = 0;

        // Iterate over all pairs of attendees
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Combine topics known by person i and person j using bitwise OR
                int combinedTopics = 0;
                for (int k = 0; k < topic.get(i).length(); k++) {
                    if (topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1') {
                        combinedTopics++;
                    }
                }

                // Update maximum topics and count teams
                if (combinedTopics > maxTopics) {
                    maxTopics = combinedTopics;
                    maxTeams = 1;
                } else if (combinedTopics == maxTopics) {
                    maxTeams++;
                }
            }
        }

        // Return the result as a list
        return Arrays.asList(maxTopics, maxTeams);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
