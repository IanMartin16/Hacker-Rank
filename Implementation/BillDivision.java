import java.io.*;
import java.util.*;

class Result {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int totalBill = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                totalBill += bill.get(i);
            }
        }
        
        int annaContribution = totalBill / 2;
        if (annaContribution == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - annaContribution);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Arrays.stream(bufferedReader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
