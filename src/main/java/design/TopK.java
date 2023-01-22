package design;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class TopK {
    public static void main(String[] args) {
        TopK topK = new TopK();
        topK.add("IDX1");
        topK.add("IDX2");
        topK.add("IDX1");
    }

    Map<String, Integer> countMap = new HashMap<>();

    public void add(String id){
        countMap.put(id, countMap.getOrDefault(id, 0) + 1);
    }


}
