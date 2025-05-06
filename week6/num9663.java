package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*N-Queen- 공통 문제*/
public class num9663 {
    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        arr= new int[N];
        NQUEEN(0);
        System.out.println(count);

    }
    public static void NQUEEN(int number) {
        // 퀸을 놓으려는 열 혹은 행의 깊이
        //모든 열에 놓았다면?? count 를 증가시킬 수 있음

        if(number==N){
            count++;
            return;
        }

        //현재 열에 i 행 퀸을 놓는다고 가정
        for (int i = 0; i < N; i++) {
            arr[number] = i;

            //유효한 위치면 다음 열로 재귀 호출
            if (Possibility(number)) {
                NQUEEN(number + 1);
            }
        }
    }
    public static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {

            if (arr[col] == arr[i]) {
                return false;
            }else if(Math.abs(col - i) ==Math.abs(arr[col]-arr[i])){
                //대각선 상에 퀸이 있을 경우 (열의 차 == 행의 차) + Math.abs()은 절댓값을 구하는 메서드
                return false;
            }



        }
        return true;
    }
}
