package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*로또*/
/*SCanner 로 풀었지만, 계속 틀렸다고 나옴
* - 원인을 알아볼 것!!ㅜㅜ
* AI 의 도움 받아=> 재풀이요1!*/
public class num2758 {

        static int count;
        static int n, m;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

            while (T-- > 0) {
                String[] input = br.readLine().split(" ");
                n = Integer.parseInt(input[0]);
                m = Integer.parseInt(input[1]);
                count = 0;

                dfs(1, 0);  // 1부터 시작, 깊이 0
                System.out.println(count);
            }
        }

        static void dfs(int start, int depth) {
            if (depth == n) {
                count++;
                return;
            }

            for (int i = start; i <= m; i++) {
                dfs(i * 2, depth + 1);
            }
        }
    }
