/* 제로-스택 */
import java.util.Scanner;
import java.util.*;

public class num10773{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int num= sc.nextInt();
            if(num==0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        System.out.println(sum);
        sc.close();
    }
}