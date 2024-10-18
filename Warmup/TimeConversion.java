import java.io.*;
import java.util.*;

class Result {

    public static String timeConversion(String s) {
        // Separar las partes de la cadena
        String[] parts = s.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2].substring(0, 2));
        String ampm = parts[2].substring(2);

        // Convertir a formato de 24 horas
        if (ampm.equals("AM") && hours == 12) {
            hours = 0;
        } else if (ampm.equals("PM") && hours != 12) {
            hours += 12;
        }

        // Formatear la salida
        String hh = String.format("%02d", hours);
        String mm = String.format("%02d", minutes);
        String ss = String.format("%02d", seconds);

        return hh + ":" + mm + ":" + ss;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
