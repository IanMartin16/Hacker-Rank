import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> colorCount = new HashMap<>();

        // Contar la cantidad de cada color de calcetín
        for (int color : ar) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }

        int pairs = 0;
        // Calcular la cantidad de pares para cada color
        for (int count : colorCount.values()) {
            pairs += count / 2;
        }

        return pairs;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
