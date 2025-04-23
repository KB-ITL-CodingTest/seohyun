package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class num18352 {


    static ArrayList<Integer>[] list;// 인접 리스트
    static int distarr[];// 거리를 저장하는 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드 수
        int m = Integer.parseInt(st.nextToken()); //엣지 수
        int k = Integer.parseInt(st.nextToken()); //원하는 거리 수
        int x = Integer.parseInt(st.nextToken()); //출발 노드

        list = new ArrayList[n + 1];// 노드
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        distarr = new int[n + 1];
        Arrays.fill(distarr, -1); // 1차원 배열 초기화할 때,
        // 2차원은 반복문을 통해서 초기화할 것, 구간 지정도 가능
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);// 단방향이니까!
        }
        bfs(x); //bfs 수행

        //거리가 k인 도시 출력
        boolean found = false;
        for (int i = 1; i < n + 1; i++) {
            if (distarr[i] == k) {
                System.out.println(i);
                found = true;
            }

        }
        if (!found)
            System.out.println(-1);


    }

static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        distarr[x] = 0;// 시작 도시
    q.add(x); //큐에 추가
    while (!q.isEmpty()) { // 큐거 비어있지 않다면?

        int cur = q.poll();
       for(int nextCity: list[cur]) {
           if (distarr[nextCity] == -1) {// 거리가 정해지지 않았다면?
               distarr[nextCity] = distarr[cur] + 1;
               q.add(nextCity);
           }
       }
    }
}
}