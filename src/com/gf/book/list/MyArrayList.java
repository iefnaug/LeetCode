package com.gf.book.list;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/*
 * Author guanfei
 * Date 2018/8/12
 * Coding Forever
 */
public class MyArrayList<T> implements Iterable<T>{

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T theItems;

    public MyArrayList(){
        this.theSize = 0;
    }

    /**
     * 保证数组容量
     * @param newCapacity
     */
    private void ensureCapacity(int newCapacity){

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = URLEncoder.encode("陈春", "utf-8");
        str = URLEncoder.encode(str, "utf-8");
        System.out.println(str);

    }
}
