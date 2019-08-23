import java.util.*;

public class P2J3 {
    
    public static void reverseAscendingSubarrays(int[] items) {
        int temp = 0;
        int count = 0;
        int j = 0;
        int i = 1;
        while (i < items.length) {
            j = i;
            while (j < items.length && items[j - 1] < items[j]) {
               count++;
               j++;
            }
            if (count > 0) {
                for (int k = 0; k <= count; k++) {
                    for (int l = i; l < (i + (count)); l++) {
                        if (items[l - 1] < items[l]) {
                            temp = items[l];
                            items[l] = items[l - 1];
                            items[l - 1] = temp;    
                        }
                    }   
                }
                i += (count + 1);
                count = 0;
            }
            else {
                i++;
            }
        }
    }
       
    public static String pancakeScramble(String text) {
        StringBuilder result = new StringBuilder(text);
        for (int i = 1; i < text.length(); i++) {
            String str = new StringBuilder(result.substring(0, i + 1)).reverse().toString();
            result.replace(0, i + 1, str);
        }
        return result.toString();
    }
    
    public static String reverseVowels(String text) {
        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> vowelSet = new HashSet<Character>();
        StringBuilder str = new StringBuilder();
        boolean[] checkCase = new boolean[text.length()];
        vowelSet.add('a'); vowelSet.add('e'); vowelSet.add('i');
        vowelSet.add('o'); vowelSet.add('u'); vowelSet.add('A');
        vowelSet.add('E'); vowelSet.add('I'); vowelSet.add('O');
        vowelSet.add('U');
        for (int i = 0; i < text.length(); i++) {
            if (vowelSet.contains(text.charAt(i))) {
                stack.push(text.charAt(i));
            }
            if (Character.isUpperCase(text.charAt(i))) {
                checkCase[i] = true;
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if (vowelSet.contains(text.charAt(i))) {
                if (checkCase[i] == true) {
                    str.append(Character.toUpperCase(stack.pop()));
                }
                else {
                    str.append(Character.toLowerCase(stack.pop()));
                }
            }
            else {
                str.append(text.charAt(i));
            }
        }
        return str.toString();
    }        

    public static boolean subsetSum(int[] items, int n, int goal) {
        if (goal == 0) {
            return true;
        }
        else if (n == 0) {
            return false;
        }
        else if (subsetSum(items, n - 1, goal) == true || subsetSum(items, n - 1, goal - items[n - 1]) == true) {
            return true;
        }
        else {
            return false;
        }
    }
}

