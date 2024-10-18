import java.io.*;
import java.util.*;

class Result {

    public static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            // Imprimir espacios
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Imprimir #
            for (int k = 1; k <= i; k++) {
                System.out.print("#");
            }
            System.out.println(); // Salto de linea despues de cada fila
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
