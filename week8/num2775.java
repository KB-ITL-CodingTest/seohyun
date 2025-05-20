package week8;

/*부녀회장이 될테야*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class num2775 {
    static int[][] apt = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아파트 인원 미리 계산
        for (int i = 0; i < 15; i++) {
            apt[0][i] = i; // 0층 i호에는 i명
        }

        for (int k = 1; k < 15; k++) {
            for (int n = 1; n < 15; n++) {
                apt[k][n] = apt[k][n - 1] + apt[k - 1][n];
            }
        }

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            System.out.println(apt[k][n]);
        }
    }
}
