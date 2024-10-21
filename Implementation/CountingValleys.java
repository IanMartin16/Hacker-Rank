import java.io.*;
import java.util.*;

class Result {

    public static int countingValleys(int steps, String path) {
        int seaLevel = 0; // Nivel del mar
        int valleys = 0; // Contador de valles
        boolean inValley = false; // Indicador de estar en un valle

        // Recorrer el camino paso a paso
        for (char step : path.toCharArray()) {
            if (step == 'U') { // Paso hacia arriba
                seaLevel++;
            } else if (step == 'D') { // Paso hacia abajo
                seaLevel--;
            }

            // Verificar si estamos en un valle
            if (!inValley && seaLevel < 0) {
                inValley = true;
                valleys++;
            }

            // Salir del valle al llegar al nivel del mar
            if (inValley && seaLevel >= 0) {
                inValley = false;
            }
        }

        return valleys;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
