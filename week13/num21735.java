package week13;


/*눈덩이 굴리기*/

/*
가장 큰 눈사람을 만들고 싶던 수수는 눈덩이를 굴리는 법을 연구했다. 눈덩이를 굴리는 방법에는 두 가지가 있다. 눈덩이를 굴리거나 던질 때 1초가 소모된다.
눈덩이를 현재 위치 +1칸으로 굴린다. 현재 칸의 위치를
$i$라고 하면 눈덩이의 크기는
$a_{i+1}$ 만큼 늘어난다.
눈덩이를 현재 위치 +2칸으로 던진다. 눈덩이가 착지하며 충격을 받아 눈덩이의 크기는 원래의 크기의 반으로 줄어들고  현재 칸의 위치를
$i$라고 하면 눈덩이의 크기는
$a_{i+2}$ 만큼 늘어난다. 이 때 소수점은 절사한다. 눈덩이를 던져 크기가
$0$이 되어도 눈덩이는 사라지지 않는다.
*/

import java.util.*;

public class num21735 {
    static int N, M;
    static int[] snow;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 눈 덩이 쌓인 거리
        M = sc.nextInt(); // 최대 시간

        snow = new int[N + 1]; // 1번부터 시작
        for (int i = 1; i <= N; i++) {
            snow[i] = sc.nextInt();
        }

        bruteForce(0, 1, 0); // 시작: 위치 0, 크기 1, 시간 0
        System.out.println(answer);
    }

    // 모든 경로를 시도하는 완전탐색 (브루트 포스)
    static void bruteForce(int pos, int size, int time) {
        if (pos >= N || time == M) {
            answer = Math.max(answer, size);
            return;
        }

        // 굴리기 (+1칸)
        if (pos + 1 <= N) {
            bruteForce(pos + 1, size + snow[pos + 1], time + 1);
        }

        // 던지기 (+2칸)
        if (pos + 2 <= N) {
            bruteForce(pos + 2, (size / 2) + snow[pos + 2], time + 1);
        }
    }
}
