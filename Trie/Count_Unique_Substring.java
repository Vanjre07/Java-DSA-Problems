import java.util.*;
public class Count_Unique_Substring {
    static class Node{
        Node children[];
        boolean eow;

        Node(){
            children = new Node[256];
            eow = false;
        }
    }
    public static void insert(String word){
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            if(i == word.length() - 1 ){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key){
        Node curr = root;

        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            if(i == key.length() - 1 && !curr.children[idx].eow ){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
        static Node root = new Node();
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i<26; i++){
            if(root.children[i] != null){
                count+= count(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[]args){
        String word = "mango";

        for(int  i = 0; i < word.length(); i++){
            String suffix = word.substring(i);
            insert(suffix);
        }
        System.out.println(count(root));
    }
}
