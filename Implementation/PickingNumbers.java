import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a); // Ordenar la lista para facilitar el cálculo
        int maxLength = 0;
        int currentLength = 1;

        for (int i = 1; i < a.size(); i++) {
            if (Math.abs(a.get(i) - a.get(i - 1)) <= 1) {
                currentLength++; // Aumentar la longitud actual si cumple la condición
            } else {
                maxLength = Math.max(maxLength, currentLength); // Actualizar la longitud máxima
                currentLength = 1; // Reiniciar la longitud actual
            }
        }

        maxLength = Math.max(maxLength, currentLength); // Manejar el caso al final de la lista

        return maxLength;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
