import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Initialize movement limits in all directions
        int up = n - r_q;
        int down = r_q - 1;
        int right = n - c_q;
        int left = c_q - 1;
        int upLeft = Math.min(n - r_q, c_q - 1);
        int upRight = Math.min(n - r_q, n - c_q);
        int downLeft = Math.min(r_q - 1, c_q - 1);
        int downRight = Math.min(r_q - 1, n - c_q);

        // Adjust movement limits based on obstacles
        for (List<Integer> obstacle : obstacles) {
            int r_o = obstacle.get(0);
            int c_o = obstacle.get(1);

            // Obstacle is in the same row
            if (r_o == r_q) {
                if (c_o < c_q) {
                    left = Math.min(left, c_q - c_o - 1);  // Left side
                } else if (c_o > c_q) {
                    right = Math.min(right, c_o - c_q - 1);  // Right side
                }
            }
            // Obstacle is in the same column
            else if (c_o == c_q) {
                if (r_o < r_q) {
                    down = Math.min(down, r_q - r_o - 1);  // Below
                } else if (r_o > r_q) {
                    up = Math.min(up, r_o - r_q - 1);  // Above
                }
            }
            // Obstacle is on a diagonal
            else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {
                if (r_o > r_q && c_o < c_q) {
                    upLeft = Math.min(upLeft, r_o - r_q - 1);  // Up-left diagonal
                } else if (r_o > r_q && c_o > c_q) {
                    upRight = Math.min(upRight, r_o - r_q - 1);  // Up-right diagonal
                } else if (r_o < r_q && c_o < c_q) {
                    downLeft = Math.min(downLeft, r_q - r_o - 1);  // Down-left diagonal
                } else if (r_o < r_q && c_o > c_q) {
                    downRight = Math.min(downRight, r_q - r_o - 1);  // Down-right diagonal
                }
            }
        }

        // Total attackable squares
        int totalAttackableSquares = up + down + left + right + upLeft + upRight + downLeft + downRight;
        return totalAttackableSquares;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);
        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
