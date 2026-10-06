import java.util.*;
public class Pascal_Triangle3 {

    public static int getInt(int row,int col) {
        int ans = 1;

        if(col < 0 || col > row){
            throw new IllegalArgumentException("Require 0 <= col <= row");
        }
        for(int i = 1; i <= col; i++){
            ans =  ans * (row - i + 1);
            ans = ans / i;
        }
        return ans;
    }

    public static void main(String[]args){
        System.out.println(getInt(5,4));
    }
}

