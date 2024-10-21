import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        
        // Arreglos para almacenar la suma de bolas por contenedor y por tipo de bola
        int[] containerSums = new int[n];
        int[] ballTypeSums = new int[n];
        
        // Calculamos la suma de bolas por contenedor y por tipo de bola
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                containerSums[i] += container.get(i).get(j); // Total bolas en el contenedor i
                ballTypeSums[j] += container.get(i).get(j);  // Total bolas del tipo j
            }
        }
        
        // Ordenamos ambos arrays
        Arrays.sort(containerSums);
        Arrays.sort(ballTypeSums);
        
        // Si los arrays son iguales, es posible organizar los contenedores
        for (int i = 0; i < n; i++) {
            if (containerSums[i] != ballTypeSums[i]) {
                return "Impossible";
            }
        }
        
        return "Possible";
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

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
