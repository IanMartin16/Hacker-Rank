class Result {

    /*
     * Complete the 'howManyGames' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER d
     *  3. INTEGER m
     *  4. INTEGER s
     */

    public static int howManyGames(int p, int d, int m, int s) {
        int gamesCount = 0;
        int currentPrice = p;
        
        // Mientras tengamos presupuesto y podamos seguir comprando juegos
        while (s >= currentPrice) {
            gamesCount++;      // Contamos el juego que estamos comprando
            s -= currentPrice; // Restamos el precio del juego de nuestro presupuesto
            
            // Calculamos el precio del próximo juego con el descuento o mínimo precio
            currentPrice = Math.max(currentPrice - d, m); // El precio no debe ser menor que m
        }
        
        return gamesCount;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);
        int m = Integer.parseInt(firstMultipleInput[2]);
        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
