import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static void miniMaxSum(List<Integer> arr) {
        // Ordenar la lista de enteros
        Collections.sort(arr);

        long minSum = 0;
        long maxSum = 0;

        // Calcular la suma mínima excluyendo el último elemento
        for (int i = 0; i < arr.size() - 1; i++) {
            minSum += arr.get(i);
        }

        // Calcular la suma máxima excluyendo el primer elemento
        for (int i = 1; i < arr.size(); i++) {
            maxSum += arr.get(i);
        }

        System.out.println(minSum + " " + maxSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
