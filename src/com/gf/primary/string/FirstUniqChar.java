package com.gf.primary.string;

/*
 * Author guanfei
 * Date 2018/7/27
 * Coding Forever
 *
 *
 *
 *
 *  字符串中的第一个唯一字符
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

    案例:

    s = "leetcode"
    返回 0.

    s = "loveleetcode",
    返回 2.


    注意事项：您可以假定该字符串只包含小写字母。
 */

import java.util.*;

public class FirstUniqChar {

    /**
     * 此方法受入参字符串的长度影响
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        if(s == null) return -1;

        char []charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char item : charArray){
            if(map.containsKey(item)){
                map.put(item, 2);
            }else{
                map.put(item, 1);
            }
        }
        for(int i=0; i<charArray.length; i++){
            if(map.get(charArray[i]) == 1){
                return i;
            }
        }

        return -1;
    }


    /**
     * 如果入参全是小写字母，则考虑小写字母一共只有26个, 时间复杂度O(n)
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s){
        int index = -1;
        for(int i='a'; i<='z'; i++){
            int firstIndex = s.indexOf(i);
            int lastIndex = s.lastIndexOf(i);
            if(firstIndex != -1 && firstIndex == lastIndex){
                index = index == -1 ? firstIndex : Math.min(index, firstIndex);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        int index = firstUniqChar2(s);
        System.out.println(index);
    }
}
