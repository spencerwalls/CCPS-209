import java.util.*; 

public class P2J1 {
    
    public static long fallingPower(int n, int k) {
        long result = n;
        if (k > 0) {
            for (int i = 1; i < k; i++) {
                result *= (n - i);
            }
            return result; 
        }
        else if (k == 0) {
            return 1;
        }
        return -1;
    }
        
    public static int[] everyOther(int[] arr) {
        ArrayList<Integer> arr2 = new ArrayList<Integer>(); 
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr2.add(arr[i]); 
            } 
        }
        int[] arr3 = new int[arr2.size()];      
        for (int i = 0; i < arr2.size(); i++) {
            arr3[i] = arr2.get(i);
        }
        return arr3;
    }
    
    public static int[][] createZigZag(int rows, int cols, int start) { 
        int[][] arr2d = new int[rows][cols]; 
        int elementCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row % 2 == 0) {
                    arr2d[row][col] = start + elementCount;
                }
                elementCount++;
            }
        }
        elementCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = cols - 1; col >= 0; col--) {
                if (row % 2 != 0) {
                    arr2d[row][col] = start + elementCount;
                }   
                elementCount++;
            }
        }            
        return arr2d; 
    }

    public static int countInversions(int[] arr) {
        int inversionCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j] && i < j) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }
}