package week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*구현 문제 ACM 호텔*/
public class num10250 {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());  // 층 수
            int W = Integer.parseInt(st.nextToken());  // 방 수
            int N = Integer.parseInt(st.nextToken());  // 손님 번호

            int floor = N % H;
            int room = (N - 1) / H + 1;

            if (floor == 0) floor = H;  // H로 나누어떨어지면 꼭대기 층

            // 방 번호 출력 (층 * 100 + 방번호)
            System.out.println(floor * 100 + room);
        }
    }
}