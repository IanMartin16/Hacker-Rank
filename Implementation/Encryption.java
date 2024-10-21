class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Eliminar los espacios del string
        s = s.replaceAll(" ", "");
        int L = s.length();
        
        // Calcular el número de filas y columnas
        int rows = (int) Math.floor(Math.sqrt(L));
        int columns = (int) Math.ceil(Math.sqrt(L));

        // Si el área de la cuadrícula no cubre toda la longitud de la cadena
        if (rows * columns < L) {
            rows++;
        }
        
        // Crear la cadena encriptada
        StringBuilder encryptedText = new StringBuilder();
        
        // Recorrer las columnas para formar el texto encriptado
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                int index = row * columns + col;
                if (index < L) {
                    encryptedText.append(s.charAt(index));
                }
            }
            encryptedText.append(" ");
        }
        
        // Retornar la cadena encriptada, eliminando cualquier espacio adicional al final
        return encryptedText.toString().trim();
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
