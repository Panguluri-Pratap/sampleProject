package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

public class HashMapTopic {
    public static void main(String[] args) {
        Map<String,Integer> hMap=new HashMap<String, Integer>();

        //put

        hMap.put("John",101);
        hMap.put("Praveen",102);
        hMap.put("Gopi",103);
        hMap.put("Ravi",104);

        System.out.println(hMap);

        System.out.println("No.Of Entries : " +hMap.size());
        System.out.println(hMap.get("John"));
        Set<Entry<String,Integer>> entries = hMap.entrySet();
        for(Entry<String,Integer> entry:entries){
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        Set<String> keys=hMap.keySet();
        System.out.println(keys);
       Collection<Integer> values= hMap.values();
        System.out.println(values);

    }
}
