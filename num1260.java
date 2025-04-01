/* 1260번 -DFS&BFS- 실버2 
 DFS은 재귀, BFS 는 큐를 사용!
*/

import java.util.*;

public class num1260{
    static ArrayList<Integer>() family;
    static boolean[] once;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int dot=sc.nextInt();

        int line=sc.nextInt();

        int num=sc.nextInt();

        family = new ArrayList[dot+1];
/* 그래프를 먼저 구성하기! */

for(int i=1;i<=dot;i++){

    family[i]= new ArrayList<>();
    }
for(int i=0;i<line;i++){
    int num1=sc.nextInt();
    int num2=sc.nextInt();
    family[num1].add[num2];
    family[num2].add[num1];

}
for(int i=1;i<=dot;i++){
   Collections.sort(family[i]);
}
once = new boolean[dot+1];
dfs();
System.out.println();

once= new boolean[dot+1];
bfs();
}

static void dfs(int one){
    once[one]=true;
    System.out.println(one +" ");

    for(int near:family[one]){
        if(!near[one]){
            dfs(near);
        }
    }
}
static void bfs(int first){
    Quenue<Integer> queue = new LinkedList<>();
    queue.add(first);
    once[first]=true;
   while(!queue.isEmpty()){
    int node =queue.poll();
    System.out.print(one+" ");
    for(int next : family[one]){
        if(!once[next]){
            once[next]=true;
            queue.add(next);

        }
    }
   }
}
}
