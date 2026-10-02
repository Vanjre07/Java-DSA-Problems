import java.util.*;
public class Starts_With {
    static class Node{
        Node children[];
        boolean eow;

        Node(){
            children = new Node[26];
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx]  == null){
                curr.children[idx] = new Node();
            }

            if(i == word.length() -1){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key){
        Node curr = root;

        for(int i = 0; i <= key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return true;
            }
            if(i == key.length() - 1 && curr.children[idx].eow == false){
                return true;
            }
            curr = curr.children[idx];
        }
        return false;
    }

    public static boolean startWith(String prefix){
        prefix = prefix.toLowerCase();
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[]args){
        String [] word = {"apple","app","mango","man","woman"};
        String key = "MOON";
        for(int i = 0; i < word.length; i++){
            insert(word[i]);
        }

        System.out.println(startWith(key));
    }
}
