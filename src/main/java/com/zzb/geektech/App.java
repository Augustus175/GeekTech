package com.zzb.geektech;

import java.net.URL;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(App.class.getClassLoader());
        URL url = App.class.getClassLoader().getResource("conf/test.txt");
        System.out.println(App.class.getClassLoader().getResource("conf/test.txt"));
        System.out.println(App.class.getClassLoader().getResource("/"));
    }
}
