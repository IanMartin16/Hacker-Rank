import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'twoPluses' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static int twoPluses(List<String> grid) {
        int n = grid.size();
        int m = grid.get(0).length();
        
        // List to store all pluses found
        List<Plus> pluses = new ArrayList<>();

        // Find all possible pluses
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).charAt(j) == 'G') {
                    // Find max arm length for this plus
                    int armLength = getMaxArmLength(grid, i, j, n, m);
                    for (int len = 0; len <= armLength; len++) {
                        pluses.add(new Plus(i, j, len));
                    }
                }
            }
        }

        int maxProduct = 0;

        // Compare all pairs of pluses and ensure they do not overlap
        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                Plus p1 = pluses.get(i);
                Plus p2 = pluses.get(j);
                if (!p1.overlaps(p2)) {
                    int area1 = p1.area();
                    int area2 = p2.area();
                    maxProduct = Math.max(maxProduct, area1 * area2);
                }
            }
        }

        return maxProduct;
    }

    // Function to get maximum arm length for a plus centered at (x, y)
    private static int getMaxArmLength(List<String> grid, int x, int y, int n, int m) {
        int maxLen = 0;
        while (x - maxLen >= 0 && x + maxLen < n && y - maxLen >= 0 && y + maxLen < m &&
               grid.get(x - maxLen).charAt(y) == 'G' && grid.get(x + maxLen).charAt(y) == 'G' &&
               grid.get(x).charAt(y - maxLen) == 'G' && grid.get(x).charAt(y + maxLen) == 'G') {
            maxLen++;
        }
        return maxLen - 1;
    }

    // Define a helper class for representing a plus
    static class Plus {
        int centerX, centerY, armLength;

        Plus(int x, int y, int len) {
            this.centerX = x;
            this.centerY = y;
            this.armLength = len;
        }

        int area() {
            return armLength * 4 + 1;
        }

        // Checks if this plus overlaps with another
        boolean overlaps(Plus other) {
            Set<String> thisPlus = getOccupiedCells();
            Set<String> otherPlus = other.getOccupiedCells();
            for (String cell : thisPlus) {
                if (otherPlus.contains(cell)) {
                    return true;
                }
            }
            return false;
        }

        Set<String> getOccupiedCells() {
            Set<String> occupied = new HashSet<>();
            for (int i = 0; i <= armLength; i++) {
                occupied.add((centerX + i) + "," + centerY); // vertical down
                occupied.add((centerX - i) + "," + centerY); // vertical up
                occupied.add(centerX + "," + (centerY + i)); // horizontal right
                occupied.add(centerX + "," + (centerY - i)); // horizontal left
            }
            return occupied;
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        int result = Result.twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
