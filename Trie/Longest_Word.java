public class Longest_Word {
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
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            if(i == word.length() - 1){
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

            if(i == key.length() - 1 && !curr.children[idx].eow){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static String ans = "";
    public static void longest(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longest(root.children[i],temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }
    public static void main(String[]args){
        String word[] = {"a","banana","app","appl","ap","apply",""};
        String key = "";

        for(int i = 0; i < word.length; i++){
            insert(word[i]);
        }
        longest(root,new StringBuilder(""));
        System.out.println(ans);
    }
}
