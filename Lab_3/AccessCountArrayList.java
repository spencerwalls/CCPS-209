import java.util.*;

public class AccessCountArrayList<E> extends ArrayList<E> {
    
    private int count;
    
    @Override public E get(int index) {
        this.count++;
        return super.get(index);
    }
    
    @Override public E set(int index, E Element) {
        this.count++;
        return super.set(index, Element);
    }
    
    public int getAccessCount() {
        return this.count;
    }
    
    public void resetCount() {
        this.count = 0;
    }
}