package LeetCode;

/**
 * LeetCode 208
 * 题意：
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 思路：额外定义一个类TrieNode(),每个节点都有一个长度26的TrieNode数组，也有一个item
 *      insert(),search(),startsWith()三个函数类似
 *      81.00% , 83.33%
 */
public class ImplementTriePrefixTree208 {
    public static void main(String[] args) {
       Trie trie = new Trie();
       trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
class Trie {
    TrieNode root ;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        char[] ch = word.toCharArray();
        for(char c : ch){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.root ;
        char[] ch = word.toCharArray();
        for(char c : ch){
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.item.equals(word);  //search()要求找到，并且到达了末尾
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        char[] ch = prefix.toCharArray();
        for(char c : ch){
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String item = "";
    TrieNode(){

    }
}