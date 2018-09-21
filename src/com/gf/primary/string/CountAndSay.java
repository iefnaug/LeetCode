package com.gf.primary.string;

/*
 * Author guanfei
 * Date 2018/9/21
 * Coding Forever
 *
 *
 * 报数
报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。



示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
 */
public class CountAndSay {

    public static String countAndSay(int n) {

        String str = "1";
        int step = 2;
        while (step <= n){
            int index = 0;
            char c = str.charAt(index);
            int len = 0;
            String temp = "";
            while(index < str.length()){
                for(int i=index; i<str.length(); i++){
                    if(c == str.charAt(i)) {
                        len++;
                        index++;
                        if(index == str.length()){
                            temp += ("" + len + c);
                            break;
                        }
                    }else{
                        temp += ("" + len + c);
                        len = 0;
                        c = str.charAt(index);
                        break;
                    }
                }

            }
            str = temp;
            step++;
        }
        return str;
    }


    public static String countAndSay2(int n) {
        String str = "1";
        int step = 2;
        while (step <= n){
            char c = str.charAt(0);
            int len = 0;

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                if(c == str.charAt(i)){
                    len++;
                }else {
                    sb.append(len).append(c);
                    len = 1;
                    c = str.charAt(i);
                }
                if(i == str.length() - 1){
                    sb.append(len).append(c);
                }
            }
            str = sb.toString();
            step++;
        }
        return str;
    }




    public static void main(String[] args) {
        System.out.println(countAndSay2(30));
    }
}
