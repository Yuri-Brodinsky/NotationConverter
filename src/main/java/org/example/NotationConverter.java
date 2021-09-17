package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotationConverter {
    private final Map<String,Integer> map;
    private final Map<Integer,String> reverseMap;
    public NotationConverter(){
        map = Map.of(
                "I",1,
                "V",5,
                "X",10,
                "L",50,
                "C",100,
                "D",500,
                "M",1000
        );
        reverseMap = new HashMap<>();
        map.entrySet().forEach(entry->reverseMap.put(entry.getValue(), entry.getKey()));

    }
    private int getValue(String key) throws InvalidValueException {
        if(!map.containsKey(key))
            throw new InvalidValueException("String must contain only valid roman numerals [I,V,X,L,C,D,M].");
        return map.get(key);
    }
    private List<Integer> convertToIntList(String number) throws InvalidValueException {
        if(number==null) throw
                new InvalidValueException("String must contain only valid roman numerals [I,V,X,L,C,D,M].");
        String [] s = number.split("");
        int value = getValue(s[0]);
        int next = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            value = getValue(s[i]);
            if(i+1<s.length){
                next = getValue(s[i+1]);
                if(value<next){
                    if(next/value>10) throw new
                            InvalidValueException("The preceding lesser numeral cannot be less than ten times.");
                    else {
                        list.add(next-value);
                        i++;
                    }
                }
                else list.add(value);
            }
            else list.add(value);
        }
        return list;
    }
    private int getResult(List<Integer> list) throws InvalidValueException {
        int n = list.size();
        int prev = list.get(0);
        int res = prev;
        int cur;
        int limit = 1;
        for(int i = 1;i<n;i++){
            cur = list.get(i);
            if(cur==prev) limit++;
            else limit = 1;
            if(cur > prev|| reverseMap.containsKey(cur+prev)||limit>3) throw
                    new InvalidValueException("The order of the numerals is violated.");
            if(limit==2&&! reverseMap.containsKey(cur)) throw
                    new InvalidValueException("The order of the numerals is violated.");
            prev = cur;
            res = res + prev;
        }
        return res;
    }
    public int toArabic(String romanNotation) throws InvalidValueException {
        return getResult(convertToIntList(romanNotation));
    }
}

