package week6;
import java.io.*;
import java.util.*;

public class num6603 {
    static int k;
    static int[] s;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean firstTestCase = true;

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line); // 아직 미숙함!! 사용하는 것!
// 입력된 첫 번째 숫자를 k로 저장하고, k개의 숫자를 담을 배열 s 생성.
            k = Integer.parseInt(st.nextToken());
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
                //입력된 숫자들을 s[] 배열에 저장.
            }

            if (!firstTestCase) {
                bw.newLine(); // 테스트 케이스 사이의 빈 줄
            }
            firstTestCase = false;

            combine(0, 0, new int[6]); //start=0, depth=0, 길이 6짜리 배열을 만들어 넘김.
        }

        bw.flush();// 모든 출력이 끝난 후 BufferedWriter와 BufferedReader를 정리 및 종료.
        bw.close();
        br.close();
    }

    // 조합 생성 함수
    static void combine(int start, int depth, int[] result) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(result[i] + (i < 5 ? " " : ""));
            }
            bw.newLine();
            return;
        }

        for (int i = start; i < k; i++) {
            result[depth] = s[i];
            combine(i + 1, depth + 1, result);
        }
    }
}