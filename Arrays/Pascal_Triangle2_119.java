import java.util.*;
public class Pascal_Triangle2_119 {

    public static List<Integer> GetRow(int row){
        long ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for(int col = 1; col <= row; col++){
            ans = ans * (row - col + 1);
            ans = ans / col;
            list.add((int)ans);
        }
        return list;
    }
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(GetRow(n));
    }
}
