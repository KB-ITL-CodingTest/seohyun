
/* 2644번 -촌수계산- 실버2*/
/* 첫째 줄에는 몇 명을 줄지에 대한 설명!
둘째 줄에는 문제에서 구하고자 하는 두 사람의 촌수
부모 -자식의 관계 수(반복문으로 돌릴것)
넷째 줄~ (x,y)의 형태로 주어지면, x는 y의 부모!
BFS- 큐! (현재 노드에서 가까운 것부터 탐색하고 다음~!)
*/
import java.util.*;

public class num2644_bfs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int people = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int relation = sc.nextInt();
        /* 가족 그래프를 구성해야 함!! */
        ArrayList<Integer>[] family = new ArrayList[people + 1];
        for (int i = 1; i <= people; i++) {
            family[i] = new ArrayList<>();
        }
        /* 숫자로 입력 받은 것을 family 그래프에 추가하기 */
        for (int i = 0; i < relation; i++) {
            int person1 = sc.nextInt();
            int person2 = sc.nextInt();
            family[person1].add(person2);
            family[person2].add(person1);
        }
        System.out.println(familyRelation(family, num1, num2, people));

    }

    public static int familyRelation(ArrayList<Integer>[] family, int num1, int num2, int people) {
        /* 방문 여부를 체크할 배열 */
        boolean[] once = new boolean[people + 1];
        int[] distance = new int[people + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num1);
        once[num1] = true;
        distance[num1] = 0;

        while (!queue.isEmpty()) {
            int firstone = queue.poll();

            for (int near : family[firstone]) {
                if (!once[near]) {
                    once[near] = true;
                    distance[near] = distance[firstone] + 1;
                    queue.add(near);

                    if (near == num2) {
                        return distance[near];
                    }
                }
            }
        }
        return -1;
    }
}
