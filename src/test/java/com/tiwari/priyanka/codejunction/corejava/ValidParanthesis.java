package com.tiwari.priyanka.codejunction.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stk = new Stack<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i=0;
        stk.push(chars[i++]);
        while(i<n){
            if(stk.isEmpty()){
                stk.push(chars[i++]);
            } else {
                if (map.get(stk.peek()) != null && map.get(stk.peek()) == chars[i]) {
                    stk.pop();
                } else {
                    stk.push(chars[i]);
                }
                i++;
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
}
