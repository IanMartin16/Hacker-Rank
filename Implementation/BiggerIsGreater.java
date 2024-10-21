class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 2;
        
        // Paso 1: Encuentra el primer carácter que sea menor que el siguiente
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        
        // Si no se encuentra tal carácter, entonces no hay mayor permutación
        if (i == -1) {
            return "no answer";
        }
        
        // Paso 2: Encuentra el carácter más pequeño a la derecha de i que sea mayor que chars[i]
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }
        
        // Paso 3: Intercambiar chars[i] y chars[j]
        swap(chars, i, j);
        
        // Paso 4: Revertir los caracteres después de la posición i
        reverse(chars, i + 1, chars.length - 1);
        
        return new String(chars);
    }
    
    // Función auxiliar para intercambiar dos caracteres en un array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    // Función auxiliar para revertir una porción de un array de caracteres
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
