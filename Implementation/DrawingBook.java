import java.io.*;
import java.util.*;

class Result {

    public static int pageCount(int n, int p) {
        int fromFront = p / 2; // Páginas a girar desde el frente
        int fromBack = (n / 2) - (p / 2); // Páginas a girar desde atrás

        return Math.min(fromFront, fromBack);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
