package com.tiwari.priyanka.codejunction.corejava;

import java.util.HashMap;

public class LongestsubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        System.out.println(getLongestSubstring("pwwkew"));
    }

    public static int getLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) == 0) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                while (true) {
                    int size = map.get(s.charAt(i));
                    if(size == 2){
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                        i++;
                        break;
                    }
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    i++;
                }
                map.put(s.charAt(j), 1);

            }
            if(res < (j-i+1)){
                res = j-i+1;
            }
            j ++;
        }
        return res;
    }
}
