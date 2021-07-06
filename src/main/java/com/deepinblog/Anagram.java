package com.deepinblog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by louisyuu on 2021/7/5 2:23 下午
 * LeetCode 第 242 题：给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 字母异位词，也就是两个字符串中的相同字符的数量要对应相等。
 * 例如，s 等于 “anagram”，t 等于 “nagaram”，s 和 t 就互为字母异位词。
 * 因为它们都包含有三个字符 a，一个字符 g，一个字符 m，一个字符 n，以及一个字符 r。
 * 而当 s 为 “rat”，t 为 “car”的时候，s 和 t 不互为字母异位词。
 */
public class Anagram {



    //最笨方法解
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

    //方法一：排序
    //tt 是 ss 的异位词等价于「两个字符串排序后相等」。因此我们可以对字符串 ss 和 tt 分别排序，看排序后的字符串是否相等即可判断。
    //此外，如果 ss 和 tt 的长度不同，tt 必然不是 ss 的异位词。
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

    //哈希表,针对a-z都是26分小写字母的情况
    //可以只利用一个长度为 26 的字符数组，将出现在字符串 s 里的字符个数加 1，而出现在字符串 t 里的字符个数减 1，最后判断每个小写字母的个数是否都为 0。
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


    //哈希表，适合Unicode字符的异位词校验
    //可以只利用一个长度为 26 的字符数组，将出现在字符串 s 里的字符个数加 1，而出现在字符串 t 里的字符个数减 1，最后判断每个小写字母的个数是否都为 0。
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
