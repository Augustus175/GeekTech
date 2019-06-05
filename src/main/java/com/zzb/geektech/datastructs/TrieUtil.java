package com.zzb.geektech.datastructs;

class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isEndChar = false;

    TrieNode(char data) {
        this.data = data;
    }
}

public class TrieUtil {
    public static void insertNode(char[] text, TrieNode root) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndChar = true;
    }

    public static boolean find(char[] text, TrieNode root) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndChar;
    }

    public static void main(String[] args) {
        String str = "helloworld";
        char[] text = str.toCharArray();
        TrieNode root = new TrieNode('/');
        TrieUtil.insertNode(text, root);
        String targetStr = "helloworld";
        char[] target = targetStr.toCharArray();
        System.out.println(TrieUtil.find(target, root));
    }
}
