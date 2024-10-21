import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    public static List<String> bomberMan(int n, List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();

        // Si n = 1, devolvemos el estado inicial
        if (n == 1) {
            return grid;
        }

        // Crear una nueva cuadrícula llena de bombas
        String[][] fullBombGrid = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(fullBombGrid[i], "O");
        }

        // Si n es par, la cuadrícula está completamente llena de bombas
        if (n % 2 == 0) {
            return Arrays.stream(fullBombGrid)
                         .map(row -> String.join("", row))
                         .collect(Collectors.toList());
        }

        // Después de 3 segundos (primera detonación)
        String[][] after3Seconds = detonate(grid);

        // Si n % 4 == 3, devolver el estado después de 3 segundos
        if (n % 4 == 3) {
            return Arrays.stream(after3Seconds)
                         .map(row -> String.join("", row))
                         .collect(Collectors.toList());
        }

        // Después de 5 segundos (segunda detonación)
        String[][] after5Seconds = detonate(toList(after3Seconds));
        return Arrays.stream(after5Seconds)
                     .map(row -> String.join("", row))
                     .collect(Collectors.toList());
    }

    private static String[][] detonate(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        String[][] newGrid = new String[rows][cols];

        // Llenamos newGrid con bombas primero
        for (int i = 0; i < rows; i++) {
            Arrays.fill(newGrid[i], "O");
        }

        // Detonar las bombas
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid.get(i).charAt(j) == 'O') { // Si hay una bomba
                    newGrid[i][j] = "."; // Limpiar la bomba misma
                    if (i > 0) newGrid[i - 1][j] = "."; // Arriba
                    if (i < rows - 1) newGrid[i + 1][j] = "."; // Abajo
                    if (j > 0) newGrid[i][j - 1] = "."; // Izquierda
                    if (j < cols - 1) newGrid[i][j + 1] = "."; // Derecha
                }
            }
        }
        return newGrid;
    }

    private static List<String> toList(String[][] grid) {
        return Arrays.stream(grid)
                     .map(row -> String.join("", row))
                     .collect(Collectors.toList());
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(Collectors.toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(Collectors.joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
