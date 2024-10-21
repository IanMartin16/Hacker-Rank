import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        
        if(arr.equals(sortedArr)) {
            System.out.println("yes");
            return;
        }
        int l = -1, r = -1;
        for(int i = 0; i < n; i++) {
            if(!arr.get(i).equals(sortedArr.get(i))) {
                if(l == -1) l = i;
                r = i;
            }
        }
        Collections.swap(arr, l, r);
        if(arr.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }
        Collections.swap(arr, l, r);
        
        List<Integer> subList = arr.subList(l, r + 1);
        Collections.reverse(subList);
        if(arr.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
            return;
        }
        System.out.println("no");

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}