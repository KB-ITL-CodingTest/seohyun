package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*전투*/
/*1.연속되는 문자열들을 탐색 -> BFS
상하좌우 중에 있으면? 계속해서 탐색을 하고, 없으면 스탐*/
/*무엇을 변수로 둘지!!
 ++ 배운 것!!:  Queue에 x, y좌표를 담기위해 만든 생성자  */
public class num1303 {

    static int N;// 전쟁터의 가로
    static int M; // 전쟁터의 세로
    static int count;
    static int countBlue;
    static int countWhite;

    static Queue<Node> que =new LinkedList<>();
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static boolean visited[][];
    static char map[][];

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }/*이게 왜 필요할까? (y, x) 두 개를 한 덩어리로 묶어서 Queue에 한 번에 넣을 수 있음.*/
    }

    public static void main(String[] args) throws IOException {//IOException은 입풀력 처리하다가 생길 수 있는 에러를 밖으로 던지겠다~

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        // 방문여부를 체크하는 배열
        map=new char[M][N];
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            String temp=st.nextToken();
            for(int j=0;j<N;j++){
                char ch=temp.charAt(j);
                map[i][j]=ch;

            }
        }
        // 순환을 위한 반복문 생성

    for(int i=0;i<M;i++){
        for(int j=0;j<N;j++){
            //false -> 방문한 적이 있는 경우
            if(visited[i][j]==false){
                if(map[i][j]=='W'){
                    int num = BFS(i,j,'W');
                    countBlue += num*num;
                }else{
                    int num = BFS(i,j,'B');
                    countWhite += num*num;
                }
            }
        }
    }
System.out.println(countWhite+" "+countBlue);
    }
static int BFS(int x,int y,char ch) {
    que.offer(new Node(y, x));
    count = 1;
    visited[y][x] = true;
    while (!que.isEmpty()) {//현재 좌표에서 상하좌우로 이동하면서 조건에 맞는 곳을 큐에 추가하는 함수.
        Range(ch);
    }
    return count;
}
static void Range(char ch) {
        // x,y좌표 두 가지를 담기 위해 Node 형으로 Queue를 만들었다!
    Node now = que.poll();
    for(int i=0;i<4;i++){
        int x=now.x+dx[i];
        int y=now.y+dy[i]; //현재 좌표에서 dy, dx만큼 이동한 새 좌표 계산.
        if(y >= 0 && y<M && x>=0 && x<N) {
            if(visited[y][x] == false && ch == map[y][x] ) {
//아직 방문 안 했고, 현재 병사의 색깔과 같은 색깔이라면...
                que.offer(new Node(y, x));
              visited[y][x] = true;
                count++;
            }


        }
    }
}





}
