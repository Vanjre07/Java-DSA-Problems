import java.util.*;
public class Pascal_Triangle1_118 {
    public static List<List<Integer>> GenerateInt(int N){
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            list.add(GenerateRow(i));
        }

        return list;
    }

    public static List<Integer> GenerateRow(int Rows){
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for(int col = 1; col < Rows; col++){
            ans = ans * (Rows - col);
            ans = ans / col;
            list.add(ans);
        }
        return list;
    }

    public static void main(String[]args){
        int n = 30;
        System.out.println(GenerateInt(n));
    }
}
