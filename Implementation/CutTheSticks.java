import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return a List of Integers.
     * The function accepts an array of integers as parameter.
     */
    public static List<Integer> cutTheSticks(int[] arr) {
        
        List<Integer> result = new ArrayList<>();
        List<Integer> sticks = new ArrayList<>();
        
        for (int length : arr) {
            sticks.add(length);
        }

        while (!sticks.isEmpty()) {
            result.add(sticks.size());
            int min = Collections.min(sticks);
            
            List<Integer> newSticks = new ArrayList<>();
            for (int length : sticks) {
                if (length > min) {
                    newSticks.add(length - min);
                }
            }
            sticks = newSticks;
        }
        return result;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[] arr = Stream.of(bufferedReader.readLine().trim().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        List<Integer> result = Result.cutTheSticks(arr);

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
