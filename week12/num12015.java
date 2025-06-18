package week12;

/*가장 긴 증가하는 부분 수열 2*/

import java.util.*;
import java.io.*;

public class num12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LIS를 저장할 리스트
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = A[i];

            // num이 들어갈 위치를 이분 탐색
            int idx = Collections.binarySearch(dp, num);

            if (idx < 0) {
                idx = -idx - 1; // 삽입할 위치 계산
            }

            if (idx == dp.size()) {
                dp.add(num); // 가장 큰 값이므로 맨 뒤에 추가
            } else {
                dp.set(idx, num); // 교체 (길이는 유지되지만 값이 작아짐)
            }
        }

        System.out.println(dp.size());
    }
}
