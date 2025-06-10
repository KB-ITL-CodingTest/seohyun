package week11;
import java.io.*;
import java.util.*;
/*회의실 배정*/
public class num1931 {
    private static class Meeting {
        long start, end;
        Meeting(long s, long e) { start = s; end = e; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] arr = new Meeting[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            arr[i] = new Meeting(s, e);
        }

        // (1) 종료 시각 기준, 같으면 시작 시각 기준 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a.end == b.end) return Long.compare(a.start, b.start);
            return Long.compare(a.end, b.end);
        });

        // (2) 그리디 선택
        long lastEnd = Long.MIN_VALUE;
        int count = 0;
        for (Meeting m : arr) {
            if (m.start >= lastEnd) {  // 겹치지 않으면 선택
                count++;
                lastEnd = m.end;
            }
        }

        // (3) 결과 출력
        System.out.println(count);
    }
}