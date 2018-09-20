package com.gf.primary.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Author guanfei
 * Date 2018/9/20
 * Coding Forever
 *
 *  有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {

        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }else{
                int num = map.get(t.charAt(i));
                if(num == 0){
                    return false;
                }else{
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            }
        }

        Set<Character> set = map.keySet();
        for(Character c : set){
           if(map.get(c) != 0){
               return false;
           }
        }

        return true;
    }


    public static boolean isAnagram2(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        char sc[] = new char[26];
        char tc[] = new char[26];

        for(int i=0; i<s.length(); i++){
            sc[s.charAt(i) - 'a']++;
            tc[t.charAt(i) - 'a']++;
        }

        for(int j=0; j<26; j++){
            if(sc[j] != tc[j]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean result = isAnagram2(s, t);
        System.out.println(result);
    }
}

