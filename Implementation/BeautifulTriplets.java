class Result {

    /*
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int count = 0; // Para contar los tríos hermosos
        
        // Recorremos el arreglo buscando tripletas
        for (int i = 0; i < arr.size(); i++) {
            int first = arr.get(i);
            // Buscamos si existe un segundo número que cumpla la diferencia 'd'
            if (arr.contains(first + d)) {
                // Si existe, buscamos un tercer número que también cumpla la diferencia 'd'
                if (arr.contains(first + 2 * d)) {
                    count++;
                }
            }
        }
        
        return count; // Retornamos la cantidad de tríos hermosos encontrados
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
