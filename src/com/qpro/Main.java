package com.qpro;

import com.qpro.util.StringUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String s = " create table employee ( id int, name text )";
        List<String> qu1 = StringUtil.splitString(s,"\\(");
        List<String> ss = StringUtil.splitString(qu1.get(0)," ");


        String columnString = qu1.get(0).replace(")" ,"");
        List<String> columns = StringUtil.splitString(columnString,",");



        System.out.println("hello");
    }



}
