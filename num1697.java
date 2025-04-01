/* 숨바꼭질- 1697번 */
import java.util.*;

public class num1697{
    static int subin, sister;
    static int[] once;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();  
        sister = sc.nextInt();  
        sc.close();
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        if (subin == sister) return 0; // 시작 위치와 목표 위치가 같다면 0초
        
        once = new int[100001]; // 이동 거리 저장 배열
        Arrays.fill(once, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        once[subin] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000 && once[next] == -1) {
                    once[next] = once[current] + 1;
                    queue.offer(next);
                    
                    if (next ==  sister) return once[next]; // 목표 위치 도달 시 리턴
                }
            }
        }
        return -1;
    }
}
