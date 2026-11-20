import java.util.*;
public class Lemanade_LT860 {
    private static boolean Note(int[]notes){
        int five = 0;
        int ten = 0;

        for(int num : notes){
            if(num == 5)    five++;
            else if(num == 10){
                if(five > 0){
                    five--;
                    ten++;
                }
                else return false;
            }
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }
                else if(five > 3){
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[]notes = {5,5,5,10,20};
        System.out.print(Note(notes));
    }
}
