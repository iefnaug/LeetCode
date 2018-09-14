package com.gf.primary.array;

/*
 * Author guanfei
 * Date 2018/9/9
 * Coding Forever
 *
 *
 * 二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 */
public class AddBinary {

    /**
     * 这个方法有点麻烦
     * @param a
     * @param b
     * @return
     */
//    public static String addBinary(String a, String b) {
//        if(a == null && b == null){
//            return null;
//        }else if(a == null){
//            return b;
//        }else if(b == null){
//            return a;
//        }
//
//        int lengthOfA = a.length();
//        int lengthOfB = b.length();
//        String longerStr = lengthOfA > lengthOfB ? a : b;
//        int containBoth = lengthOfA > lengthOfB ? lengthOfB : lengthOfA;
//        int lengthOfArr = lengthOfA > lengthOfB ? lengthOfA : lengthOfB;
//        int []arr = new int[lengthOfArr];
//
//        int plus = 0;
//        int reduceIndex = 1;
//        while(reduceIndex <= lengthOfArr){
//            if(reduceIndex <= containBoth){
//                int result = a.charAt(lengthOfA - reduceIndex) + b.charAt(lengthOfB - reduceIndex) + plus - 96;
//                if(result > 1){
//                    plus = 1;
//                    arr[lengthOfArr - reduceIndex] = result - 2;
//                }else{
//                    plus = 0;
//                    arr[lengthOfArr - reduceIndex] = result;
//                }
//
//            }else{
//                int result = longerStr.charAt(longerStr.length() - reduceIndex) - 48 + plus;
//                if(result > 1){
//                    plus = 1;
//                    arr[lengthOfArr - reduceIndex] = 0;
//                }else{
//                    plus = 0;
//                    arr[lengthOfArr - reduceIndex] = result;
//                }
//            }
//            reduceIndex++;
//        }
//        if(plus == 1){
//            int newArr[] = new int[arr.length + 1];
//            newArr[0] = 1;
//            System.arraycopy(arr, 0, newArr, 1, arr.length);
//            arr = newArr;
//        }
//
//        String str = "";
//        for(int each : arr){
//            str += each;
//        }
//        return str;
//    }

    public static String addBinary2(String a, String b){
        if(a == null && b == null){
            return null;
        }else if(a == null){
            return b;
        }else if(b == null){
            return a;
        }

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        if(arrA.length > arrB.length){
            char []newArrB = new char[arrA.length];
            System.arraycopy(arrB, 0, newArrB, newArrB.length - arrB.length, arrB.length);
            for(int i=0; i<newArrB.length - arrB.length; i++){
                newArrB[i] = '0';
            }
            arrB = newArrB;
        }else{
            char []newArrA = new char[arrB.length];
            System.arraycopy(arrA, 0, newArrA, newArrA.length - arrA.length, arrA.length);
            for(int i=0; i<newArrA.length - arrA.length; i++){
                newArrA[i] = '0';
            }
            arrA = newArrA;
        }
        int plus = 0;
        for(int i = arrA.length-1; i >= 0; i--){
            int result = (int)arrA[i] + (int)arrB[i] - 96 + plus;
            if(result > 1) {
                plus = 1;
                arrA[i] = (char)(result + 46);
            }else{
                plus = 0;
                arrA[i] = (char)(result + 48);
            }

        }
        if(plus == 1){
            return "1" + new String(arrA);
        }
        return new String(arrA);
    }

    public static void main(String[] args){
        String a = "11";
        String b = "1";
        System.out.println(addBinary2(a, b));
//        System.out.println((int)'0');
    }
}
