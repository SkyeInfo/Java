/**
 * @author SkyeInfo
 * @LastModifyTime 2017/8/28
 * @LastModify SkyeInfo
 */
import java.util.Scanner;
class Main{
    public int getFNum(int i){
        if(i == 1){
            return 0;
        }
        if(i == 2){
            return 1;
        }
        return getFNum(i - 1) + getFNum(i - 2);
    }
    public static void main(String a[]){
        Scanner sc = new Scanner();
        int m = sc.nextInt();
        int temp = 0;
        while(m > getFNum(temp)){
            temp++;
        }

        int x = getFNum(temp);
        int y = getFNum(temp + 1);

        int res = (m-x) < (m-y) ? m-x : m-y
        System.out.print(res);
    }
}










