import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // List to store rounded grades
        List<Integer> roundedGrades = new ArrayList<>();

        // Iterate through the grades
        for (int grade : grades) {
            // If grade is less than 38, no rounding needed
            if (grade < 38) {
                roundedGrades.add(grade);
            } else {
                // Calculate the next multiple of 5
                int nextMultipleOf5 = (int) Math.ceil(grade / 5.0) * 5;

                // If the difference is less than 3, round up
                if (nextMultipleOf5 - grade < 3) {
                    roundedGrades.add(nextMultipleOf5);
                } else {
                    // Otherwise, keep the original grade
                    roundedGrades.add(grade);
                }
            }
        }

        return roundedGrades;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount)
            .mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
