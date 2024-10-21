import java.util.*;

class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     */

    public static int equalizeArray(List<Integer> arr) {
        // Crear un mapa para contar la frecuencia de cada número
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Llenar el mapa con las frecuencias de los números
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Encontrar el número con la mayor frecuencia
        int maxFrequency = Collections.max(frequencyMap.values());
        
        // El número de eliminaciones es el tamaño del array menos la frecuencia máxima
        return arr.size() - maxFrequency;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        
        int result = Result.equalizeArray(arr);
        System.out.println(result);
        
        scanner.close();
    }
}
