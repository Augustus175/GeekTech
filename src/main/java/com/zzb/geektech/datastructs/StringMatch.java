package com.zzb.geektech.datastructs;

public class StringMatch {
    public static void main(String[] args) {

    }

    //          abcdef
// aabbccddeebcdef
    public int betterSuffix(String originalString, String modle) {
        int m;
        int ol = originalString.length();
        int ml = modle.length();
        int[] suffix = new int[ml];
        for (int i = ml - 1; i > 0; i--) {
            int t = i;
            for (int j = ml - i; j >= 0; j--) {
                if (modle.charAt(j) == modle.charAt(t)) {

                }
            }
        }
        return 1;
    }
}
