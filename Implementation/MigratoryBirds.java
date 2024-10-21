import java.io.*;
import java.util.*;

class Result {

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> sightings = new HashMap<>();
        int maxCount = 0;
        int mostFrequentBird = Integer.MAX_VALUE;
        
        // Contar las apariciones de cada tipo de pájaro
        for (int bird : arr) {
            sightings.put(bird, sightings.getOrDefault(bird, 0) + 1);
            maxCount = Math.max(maxCount, sightings.get(bird));
        }
        
        // Encontrar el pájaro más frecuente
        for (Map.Entry<Integer, Integer> entry : sightings.entrySet()) {
            int birdType = entry.getKey();
            int count = entry.getValue();
            if (count == maxCount && birdType < mostFrequentBird) {
                mostFrequentBird = birdType;
            }
        }
        
        return mostFrequentBird;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Arrays.stream(bufferedReader.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
