import java.util.*;
public class Count_Substring {
    public static long Substring(String s){
        Map<String,Integer> map = new HashMap<>();
        int  []freq = new int [10];
        long ans = 0;
        map.put("0000000000",1);

        for(char ch : s.toCharArray()){
            int index = ch - 'a';
            freq[index]++;
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 10; i++){
                sb.append(freq[i] % 2);
            }
            String current = sb.toString();

            ans += map.getOrDefault(current,0);

            for(int i = 0; i < 10; i++){
                char []arr = current.toCharArray();
                arr[i] = (arr[i] == '0') ? '1' : '0';
                String newKey = new String(arr);
                ans += map.getOrDefault(newKey,0);
            }
            map.put(current,map.getOrDefault(current,0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "aba";
        System.out.print(Substring(s));
    }
}
