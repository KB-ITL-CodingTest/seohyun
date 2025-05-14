package week7;

import java.io.*;
/*숫자의 개수 - 구현 문제*/
public class num2577 {
        public static void main(String[] args) throws IOException {
            // 입력을 받기 위한 BufferedReader 사용
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 입력 값 A, B, C 읽기
            int A = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());
            int C = Integer.parseInt(br.readLine());

            // 곱셈 결과 계산
            int result = A * B * C;

            // 숫자 개수를 저장할 배열 선언 (0~9까지 총 10개)
            int[] count = new int[10];

            // 결과를 문자열로 변환하여 각 문자(숫자)를 하나씩 검사
            String str = String.valueOf(result);
            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';  // 문자 '0'을 빼서 숫자화
                count[digit]++;
            }

            // 결과 출력 (0부터 9까지)
            for (int i = 0; i < 10; i++) {
                System.out.println(count[i]);
            }
        }
    }
