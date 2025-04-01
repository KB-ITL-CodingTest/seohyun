/* 2644번 -촌수계산- 실버2*/
/* 첫째 줄에는 몇 명을 줄지에 대한 설명!
둘째 줄에는 문제에서 구하고자 하는 두 사람의 촌수
부모 -자식의 관계 수(반복문으로 돌릴것)
넷째 줄~ (x,y)의 형태로 주어지면, x는 y의 부모!
DFS(깊이 우선 탐색) -> 자료구조: 스택! => 재귀 함수! 
*/
import java.util.*;
public class num2644_dfs{
    static ArrayList<Integer>[] family;
    static boolean[] once;
    static int result = -1;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int people = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int relation =sc.nextInt();


        family = new ArrayList[people + 1];
        once = new boolean[people + 1];
        
for(int i=1;i<=people;i++){
    family[i]=new ArrayList<>();
}
/* 그래프를 구성! */
for(int i=0;i<relation;i++){
    int person1=sc.nextInt();
    int person2= sc.nextInt();
    family[person1].add(person2);
    family[person2].add(person1);

}
     dfs(num1, num2, 0);  
        System.out.println(result);  
    
 

    }

 static void dfs(int eachone, int target, int count) {  
        if (eachone == target) {
            result = count;  
            return;
        }
        
        once[eachone] = true;
        for(int check:family[eachone]){
            if (!once[check]) { 
             dfs(check, target, count + 1);
        }
        }
    }
}