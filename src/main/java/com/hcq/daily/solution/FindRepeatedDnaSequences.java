package com.hcq.daily.solution;

import java.util.*;

public class FindRepeatedDnaSequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> cons = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String cur = s.substring(i, i + 10);
            int count = map.getOrDefault(cur, 0);
            if (count == 1) {
                cons.add(cur);
            }
            map.put(cur, count + 1);
        }
        return cons;
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
