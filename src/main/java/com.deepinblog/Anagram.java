package com.deepinblog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by louisyuu on 2021/7/5 2:23 下午
 */
public class Anagram {


    public boolean isAnagram(String s, String t) {


        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCharMap = new HashMap<>();
        Map<Character, Integer> tCharMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            Integer count = sCharMap.get(c);
            if (count == null) {
                sCharMap.put(c, 1);
            } else {
                sCharMap.put(c, count + 1);
            }
        }
        for (Character c : t.toCharArray()) {
            Integer count = tCharMap.get(c);
            if (count == null) {
                tCharMap.put(c, 1);
            } else {
                tCharMap.put(c, count + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : sCharMap.entrySet()) {
            Integer tCount = tCharMap.get(entry.getKey());
            if (tCount == null) {
                return false;
            }

            if (!entry.getValue().equals(tCount)) {
                return false;
            }

        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] tArray = s.toCharArray();
        char[] sArray = t.toCharArray();

        Arrays.sort(tArray);
        Arrays.sort(sArray);

        return Arrays.equals(tArray, sArray);


    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            table.put(c, table.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);

            table.put(c, table.getOrDefault(c, 0) - 1);

            if(table.get(c)<0){
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("Is anagram " + new Anagram().isAnagram3("rat", "car"));
        System.out.println("Is anagram " + new Anagram().isAnagram3("anagram", "nagaram"));
    }

}
