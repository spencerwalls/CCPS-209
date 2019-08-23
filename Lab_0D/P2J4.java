import java.util.*;

public class P2J4 {
    
    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        List<Integer> list = new ArrayList<Integer>();
        if (items.size() > 2) {
            list.add(items.get(0)); list.add(items.get(1));
            for (int i = 2; i < items.size(); i++) {
                List<Integer> list2 = new ArrayList<Integer>(items.subList(i - 2, i + 1));
                Collections.sort(list2);
                list.add(list2.get(1));
            }
            return list;
        }
        else {
            return items;
        }
    }
    
    public static int firstMissingPositive(List<Integer> items) {
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int e: items) {
            hash.add(e);
        }
        for (int i = 1; i < items.size(); i++) {
            if (!hash.contains(i)) {
                return i;
            }
        }
        return 1;
    }
    
    public static void increment(Map<Integer, Integer> map, Integer key) {
        map.putIfAbsent(key, Integer.valueOf(0));
        map.put(key, map.get(key) + Integer.valueOf(1));
    }
    
    public static void sortByElementFrequency(List<Integer> items) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer e: items) {
            increment(map, e);
        }
        class Comparison implements Comparator<Integer> {
            public int compare(Integer a, Integer b) {
                if (map.get(a) == map.get(b)) {
                    return a - b;
                }
                else {
                    return map.get(b) - map.get(a);
                }
            }
        }
        Collections.sort(items, new Comparison());           
    }
    
    public static List<Integer> factorFactorial(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            int num = i;
            for (int j = 2; j <= num; j += 2) {
                while (num % j == 0) {
                    list.add(j);
                    num /= j;
                }
                if (j == 2) {
                    j--;
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}