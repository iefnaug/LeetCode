package com.gf.leetcode.arraystring;

/*
 * Author guanfei
 * Date 2018/12/1
 */

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {

    /**
     * brute-force
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() == 0){
            return 0;
        }
        int haystack_len = haystack.length(), needle_len = needle.length();
        for(int i=0; i<=haystack_len-needle_len; i++){
            int needle_index = 0;
            while(needle_index < needle_len){
                if(haystack.charAt(i + needle_index) == needle.charAt(needle_index)){
                    needle_index++;
                }else{
                    break;
                }
            }
            if (needle_index == needle_len){
                return i;
            }
        }
        return -1;
    }


    /**
     * KMP
     * @param haystack
     * @param needle
     * @return
     */
    public int kmp(String haystack, String needle){
        if(haystack == null || needle == null){
            return -1;
        }else if(needle.length() == 0){
            return 0;
        }else if(haystack.length() < needle.length()){
            return -1;
        }
        int haystack_len = haystack.length(), needle_len = needle.length();
        int i = 0, j = 0;
        int[] pls = calculate_pls(needle);
        while(i < haystack_len){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j > 0){
                    j = pls[j-1];
                }else{
                    i++;
                }
            }
            if(j == needle_len){
                return i - j;
            }
        }
        return -1;
    }


    //KMP -- 计算pattern每个位置的最长公共前后缀
    public int[] calculate_pls(String pattern){
        int[] pls = new int[pattern.length()];
        pls[0] = 0;
        int len = 0, k = 1;
        while (k < pattern.length()){
            if(pattern.charAt(len) == pattern.charAt(k)){
                pls[k]  = ++len;
                k++;
            }else{
                if(len > 0){
                    len = pls[len-1];
                }else{
                    pls[k++] = 0;
                }
            }
        }
        return pls;
    }



    public static void main(String[] args) {
        ImplementstrStr implementstrStr = new ImplementstrStr();
        String haystack = "";
        String needle = "";
        System.out.println(implementstrStr.kmp(haystack, needle));
//        int[] next = implementstrStr.calculate_pls(needle);
//        for(int each : next){
//            System.out.print(each + ",");
//        }
    }
}
