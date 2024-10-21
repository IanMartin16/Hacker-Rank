import java.io.*;
import java.util.*;

public class Solution {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxCost = -1; // Inicializar el costo máximo como -1 por defecto

        // Recorrer los precios de los teclados
        for (int keyboardPrice : keyboards) {
            // Recorrer los precios de las unidades USB
            for (int drivePrice : drives) {
                int totalCost = keyboardPrice + drivePrice;
                // Verificar si el costo total es menor o igual al presupuesto y mayor que el costo máximo actual
                if (totalCost <= b && totalCost > maxCost) {
                    maxCost = totalCost; // Actualizar el costo máximo
                }
            }
        }

        return maxCost; // Devolver el costo máximo o -1 si no es posible comprar ambos elementos
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = bufferedReader.readLine().split(" ");
        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];
        String[] keyboardsItems = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            keyboards[i] = Integer.parseInt(keyboardsItems[i]);
        }

        int[] drives = new int[m];
        String[] drivesItems = bufferedReader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            drives[i] = Integer.parseInt(drivesItems[i]);
        }

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
