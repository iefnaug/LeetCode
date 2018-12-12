package com.gf.leetcode.arraystring;

/**
 * Longest Common Prefix
 *   Go to Discuss
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {

//    public String longestCommonPrefix(String[] strs) {
//
//        if(strs == null || strs.length == 0){
//            return "";
//        }
//        String commonStr = strs[0];
//        for(int i=1; i<strs.length; i++){
//            int shorterLen = Math.min(commonStr.length(), strs[i].length());
//            char[] commonChar = new char[shorterLen];
//            int index=0;
//            for( ; index<shorterLen; index++){
//                if(commonStr.charAt(index) != strs[i].charAt(index)){
//                    if(index == 0){
//                        return "";
//                    }
//                    break;
//                }else{
//                    commonChar[index] = commonStr.charAt(index);
//                }
//            }
//            commonStr = new String(commonChar, 0, index);
//        }
//        return commonStr;
//    }

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        char[] commonChar = strs[0].toCharArray();
        int len = commonChar.length; //the actually length of the common prefix
        for(int i=1; i<strs.length; i++){
            int maxCompareLen = Math.min(commonChar.length, strs[i].length());
            char[] replaceCommonChar = new char[maxCompareLen];
            int index=0;
            for(; index<maxCompareLen; index++){
                if(commonChar[index] != strs[i].charAt(index)){
                    if(index == 0){
                        return "";
                    }
                    break;
                }else{
                    replaceCommonChar[index] = commonChar[index];
                }
            }
            commonChar = replaceCommonChar;
            len = index;
        }
        return new String(commonChar, 0, len);

    }

    public static void main(String[] args) {
        String[] strs = {
                "flower",
                "flow",
                "flight",
        };

        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String commonStr = prefix.longestCommonPrefix(strs);
        System.out.println(commonStr);

    }
}
