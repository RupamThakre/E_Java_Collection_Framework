import java.util.concurrent.*;
import java.util.*;

class LRUCache<K,V> extends LinkedHashMap<K, V>{

    private int capacity;

    public LRUCache(int capacity){
        // true = access-order (not insertion-order)
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    // This method is called after each put or putAll
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > capacity; // remove the eldest if size exceeds capacity
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
        studentMap.put("Bob", 100);
        studentMap.put("Vipul", 89);


        System.out.println(studentMap);
        //Output : {Ram=91, Bob=100, Vipul=89}

    }


}