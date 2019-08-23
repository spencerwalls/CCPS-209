import java.util.*;

public class Polynomial implements Comparable<Polynomial> {
    
    private int[] coefficients;
    
    @Override public String toString() {return Arrays.toString(this.coefficients);}
    
    public Polynomial(int[] coefficients) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] == 0) {
                count++;
            }
        }
        if (count != coefficients.length) {
            for (int i = 0; i < coefficients.length; i++) {
                al.add(coefficients[i]);
            }
            for (int i = al.size() - 1; i >= 0; i--) {
                if (al.get(i) == 0) {
                    al.remove(i);
                }
                else {
                    break;
                }
            }
            int[] coefficients2 = new int[al.size()];
            for (int j = 0; j < al.size(); j++) {
                coefficients2[j] = al.get(j);
            }
            this.coefficients = coefficients2.clone();
        }
        else {
            int[] arr = new int[1];
            arr[0] = 0;
            this.coefficients = arr.clone();
        }
    }
    
    public int getDegree() {
        for (int i = this.coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                return i;
            }
        }
        return 0;
    }
    
    public int getCoefficient(int k) {
        if (k < this.coefficients.length && k >= 0) {
            return this.coefficients[k];
        }
        else {
            return 0;
        }
    }
    
    public long evaluate(int x) {
        int result = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            result += this.coefficients[i] * (Math.pow(x, i));
        }
        return result;
    }          
    
    public Polynomial add(Polynomial other) {
        int n = Math.min(this.coefficients.length, other.coefficients.length); 
        int m = Math.max(this.coefficients.length, other.coefficients.length);    
        int[] a = new int[m]; 
        for (int i = 0; i < n; i++) {
            a[i] = this.coefficients[i] + other.coefficients[i]; 
        }
        if (this.coefficients.length > other.coefficients.length) {
            for (int j = n; j < this.coefficients.length; j++) {
                a[j] = this.coefficients[j];
            }
        }
        else if (this.coefficients.length < other.coefficients.length) {
            for (int k = n; k < other.coefficients.length; k++) {
                a[k] = other.coefficients[k];
            }      
        }
        return new Polynomial(a);
    }
    
    public Polynomial multiply(Polynomial other) {
        int n1 = this.coefficients.length;
        int n2 = other.coefficients.length;
        int n3 = (n1 + n2) - 1;
        int[] a = new int[n3];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) { 
                a[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }
        return new Polynomial(a);
    }
    
    @Override public boolean equals(Object other)  {
        if (other instanceof Polynomial) {
            if (this.compareTo((Polynomial) other) == 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override public int hashCode() {
        return Arrays.hashCode(this.coefficients);   
    }
    
    public int compareTo(Polynomial other) {
        if (this.coefficients.length > other.coefficients.length && 
            this.coefficients[this.coefficients.length - 1 ] != 0) {
            return 1;
        }
        else if (this.coefficients.length < other.coefficients.length &&
                 other.coefficients[other.coefficients.length - 1 ] != 0) {
            return -1;
        }
        else if (this.coefficients.length == other.coefficients.length) {
            for (int i = this.coefficients.length - 1; i >= 0; i--) {
                if (this.coefficients[i] > other.coefficients[i]) {
                    return 1;
                }
                else if (this.coefficients[i] < other.coefficients[i]) {
                    return -1;
                }
            }
        }
        return 0;
    }
}




