package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*근손실*/
/*운동키트의 개수는 N, 매일 줄어드는 중량은 K 임*/
public class num18429 {
    static int N,K;
    static int[] kit;
    static boolean[] visited;
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫줄에 입력할 숫자들
        String[] s = br.readLine().split(" ");
        N=Integer.parseInt(s[0]);
        K=Integer.parseInt(s[1]);
        // 두번째 줄 입력: 운동키트 배열
        kit = new int[N];
        visited = new boolean[N];
        String[] line=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            kit[i]=Integer.parseInt(line[i]);
        }
        dfs(0,500);
        System.out.println(answer);

    }
    public static void dfs(int x,int y){
        // 몇번째 날인지: x, 현재 중량:y
        if(x==N){
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                int next= y-K+kit[i];
                if(next>=500){
                    visited[i]=true;
                    dfs(x+1,next);
                    visited[i]=false;

                }
            }
        }
    }
}
