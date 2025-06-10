package week11;


/*강의실 배정 */
import java.io.*;
import java.util.*;

public class num11000  {

    private static class Lecture {
        int start, end;
        Lecture(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] arr = new Lecture[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(s, t);
        }

        // 1) 시작 시간 기준 정렬
        Arrays.sort(arr, Comparator.comparingInt(l -> l.start));

        // 2) 종료 시각 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Lecture lec : arr) {
            // 가장 빨리 끝나는 강의실이 비었으면 재사용
            if (!pq.isEmpty() && pq.peek() <= lec.start) {
                pq.poll();
            }
            // 이 강의의 종료 시각 push
            pq.offer(lec.end);
        }

        // 3) 힙에 남은 개수 = 최소 강의실 수
        System.out.println(pq.size());
    }
}

