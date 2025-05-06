package week6;

import java.util.Scanner;

/*부분수열의 합*/
/* 문제에 대한 파악 */
/*문제에 대힌 접근
1 정수들을 입력 받는다.
2. 반복문 => 전체 합으로 착각하지 말 것
3.
4.
*/
public class num1182 {
    static int count = 0;
    static int num,target;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        target = sc.nextInt();
        arr = new int[num];
        int sum =0;

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            }
        dfs(0,0);
        // 공집합은 빼줘야 함!
        if(target==0){
            count--;
        }
        System.out.println(count);
    }
    public static void dfs(int idx, int sum){
        if(idx==num){
            if(sum==target){
                count++;
            }
            return;
        }
        /*기억해두기!! 현재 인덱스의 원소를 포함할 것인지*/
        dfs(idx+1, sum+arr[idx]);
        /*현재 인덱스의 원소를 포함하지 않을 것인지*/
        dfs(idx+1, sum);
    }

}
