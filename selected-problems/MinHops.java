import java.util.*;

public class MinHops {

    public static void main(String args[]) {
        int n = 6;
        
        /*
        
            Given two words - beginning word and end word
            And a list of words which provides the path to convert beginning word into end word.
            In every step, you can change a letter of the beginning word and that hop is valid if the new string is present in the list
        
        */
        
        String beginString = "git", endString = "gog";

        String[] stringArray = {
            "got",
            "dot",
            "log",
            "fog",
            "mot",
            "pkm"
        };


        TrieNode root = new TrieNode();
        for(int i = 0 ; i < stringArray.length; i++) 
            root.insert(stringArray[i]);

        int begLen = beginString.length(), endLen = endString.length();
        // printTrie(root, "");
        if(begLen != endLen)
            System.out.println(-1);
        else {
            System.out.println(solveUsingQueue(root, beginString, endString));
        }

    }

    static void printTrie(TrieNode root, String s){

        if(root == null)
            return;
        if(root.isEndOfString)
            System.out.println(s);
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                int a = (int)'a';
                a += i; 
                printTrie(root.children[i], s+String.valueOf((char)a));
            }
        }

    }

    static int solveUsingQueue(TrieNode root, String begString, String endString) {
        int n = begString.length(), hop = 0;
        
        Queue<WordWithHop> queue = new LinkedList<WordWithHop>();
        WordWithHop wWH = new WordWithHop(); 
        wWH.hop = hop;
        wWH.word = begString;
        
        queue.add(wWH);

        while(!queue.isEmpty()) {
            WordWithHop wordWithHop = queue.poll();
            String str = wordWithHop.word;
            System.out.println(str);
            hop++;
            
            if(endString.equals(str)) {
                wWH = wordWithHop;
                break;
            }

            for(int i = 0; i < n; i++) {
                if(str.charAt(i) != endString.charAt(i)) {
                    String s = str.substring(0,i) + endString.substring(i, i+1); 
                    s += (i != n-1) ? str.substring(i+1) : "";
                    if(root.search(s) || s.equals(endString)) {
                        WordWithHop withHop = new WordWithHop();
                        withHop.word = s;
                        withHop.hop = hop;
                        queue.add(withHop);
                    }
                }
            }
        }

        if(endString.equals(wWH.word)) {
            return wWH.hop;
        }
        return -1;

    }

    static class WordWithHop {
        String word;
        int hop;

    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABETS];
        boolean isEndOfString;

        static int ALPHABETS = 26; 
        TrieNode() {
            isEndOfString = false;
            for(int i = 0 ; i < ALPHABETS; i++)
                children[i] = null;
        }

        void insert(String key) {
            
            int length = key.length();

            TrieNode tNode = this;

            for(int l = 0; l < length ; l++ ){
                int index = key.charAt(l) - 'a';

                if(tNode.children[index] == null)
                    tNode.children[index] = new TrieNode();

                tNode = tNode.children[index];
            }

            tNode.isEndOfString = true;

        }

        boolean search(String key) {
            int length = key.length();

            TrieNode tNode = this;

            for(int i = 0; i < length; i++) {
                
                int index = key.charAt(i) - 'a';
                // index -= (int)'a';
                if(tNode.children[index] == null)
                    return false;
                tNode = tNode.children[index];
            }
            return (tNode != null && tNode.isEndOfString);
        }
    }
}
