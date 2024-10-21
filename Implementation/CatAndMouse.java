import java.io.*;
import java.util.*;

public class Solution {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        int distanceToCatA = Math.abs(z - x); // Distancia del ratón al gato A
        int distanceToCatB = Math.abs(z - y); // Distancia del ratón al gato B

        if (distanceToCatA < distanceToCatB) {
            return "Cat A"; // Cat A alcanza al ratón primero
        } else if (distanceToCatB < distanceToCatA) {
            return "Cat B"; // Cat B alcanza al ratón primero
        } else {
            return "Mouse C"; // Ambos gatos llegan al mismo tiempo, el ratón escapa
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
