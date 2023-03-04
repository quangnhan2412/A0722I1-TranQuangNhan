package org.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("mouse", "chuột");
        stringMap.put("cat", "mèo");
        stringMap.put("dog", "chó");
        stringMap.put("tiger", "hổ");
        stringMap.put("lion", "sư tử");
    }


    @Override
    public String searchEng(String eng) {
        if(stringMap.containsKey(eng)){
            return stringMap.get(eng);
        }
        return "Your word is not in my dictionary yet";
    }
}
