import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */
    
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();         // Number of rows
        int n = matrix.get(0).size();  // Number of columns
        
        // Calculate the number of layers
        int layers = Math.min(m, n) / 2;
        
        // For each layer
        for (int layer = 0; layer < layers; layer++) {
            // Extract the elements of the current layer into a list
            List<Integer> elements = extractLayer(matrix, layer, m, n);
            int numElements = elements.size();
            
            // Calculate the effective number of rotations needed
            int effectiveRotations = r % numElements;
            
            // Rotate the layer
            List<Integer> rotatedLayer = new ArrayList<>(elements.subList(effectiveRotations, numElements));
            rotatedLayer.addAll(elements.subList(0, effectiveRotations));
            
            // Place the rotated layer back into the matrix
            placeLayer(matrix, layer, rotatedLayer, m, n);
        }
        
        // Print the rotated matrix
        printMatrix(matrix);
    }

    // Function to extract the elements of a specific layer
    private static List<Integer> extractLayer(List<List<Integer>> matrix, int layer, int m, int n) {
        List<Integer> elements = new ArrayList<>();
        
        // Top row (left to right)
        for (int i = layer; i < n - layer; i++) {
            elements.add(matrix.get(layer).get(i));
        }
        
        // Right column (top to bottom)
        for (int i = layer + 1; i < m - layer; i++) {
            elements.add(matrix.get(i).get(n - layer - 1));
        }
        
        // Bottom row (right to left)
        for (int i = n - layer - 2; i >= layer; i--) {
            elements.add(matrix.get(m - layer - 1).get(i));
        }
        
        // Left column (bottom to top)
        for (int i = m - layer - 2; i > layer; i--) {
            elements.add(matrix.get(i).get(layer));
        }
        
        return elements;
    }

    // Function to place the rotated layer back into the matrix
    private static void placeLayer(List<List<Integer>> matrix, int layer, List<Integer> elements, int m, int n) {
        int index = 0;
        
        // Top row (left to right)
        for (int i = layer; i < n - layer; i++) {
            matrix.get(layer).set(i, elements.get(index++));
        }
        
        // Right column (top to bottom)
        for (int i = layer + 1; i < m - layer; i++) {
            matrix.get(i).set(n - layer - 1, elements.get(index++));
        }
        
        // Bottom row (right to left)
        for (int i = n - layer - 2; i >= layer; i--) {
            matrix.get(m - layer - 1).set(i, elements.get(index++));
        }
        
        // Left column (bottom to top)
        for (int i = m - layer - 2; i > layer; i--) {
            matrix.get(i).set(layer, elements.get(index++));
        }
    }

    // Function to print the matrix
    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
