import java.util.*;

public class P2J2 {
    
    public static String removeDuplicates(String text) { 
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i == text.length() - 1) {
                s.append(text.charAt(i));
            }
            else if (text.charAt(i) != text.charAt(i + 1)) {
                s.append(text.charAt(i));
            }
        }
        return s.toString();
    }
    
    public static String uniqueCharacters(String text) { 
        StringBuilder s = new StringBuilder();
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < text.length(); i++) {
            if (set.contains(text.charAt(i)) == false) {
                s.append(text.charAt(i));
                set.add(text.charAt(i));
            }
        }
        return s.toString();
    }
    
    public static int countSafeSquaresRooks(int n, boolean[][] rooks) { 
        int countRow = 0;
        int countCol = 0;
        int countSafeSquares = 0;
        boolean[] memTableRow = new boolean[n];
        boolean[] memTableCol = new boolean[n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (memTableRow[row] == true) {
                    break;
                }
                else if (memTableCol[col] == true) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if (rooks[row][i] == false) {
                        countRow++;
                    }
                }
                if (countRow != n) {
                    memTableRow[row] = true;
                }
                for (int j = 0; j < n; j++) {
                    if (rooks[j][col] == false) {                         
                        countCol++;
                    }
                }
                if (countCol != n) {
                    memTableCol[col] = true;
                }                      
                if (countRow == n && countCol == n) {
                    countSafeSquares++;
                }
                countRow = countCol = 0;
            }
        }
        return countSafeSquares;
    }
    
    public static int recaman(int n) { 
        int nthTerm = 0;
        int temp = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        if (n >= 1) {
            for (int i = 1; i <= n; i++) {
                temp = nthTerm - i;
                if (temp > 0 && set.contains(temp) == false) {
                    nthTerm = temp;
                    set.add(nthTerm);
                }
                else {
                    nthTerm += i;
                    set.add(nthTerm);
                }
            }
            return nthTerm;
        }
        else {
            return -1;
        }
    }
}
    