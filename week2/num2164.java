import java.util.*;

public class num2164{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        int N = sc.nextInt();  

        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 넣기
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 카드가 1장 남을 때까지 반복
        while (queue.size() > 1) {
            queue.poll(); // 제일 위에 있는 카드 버리기
            int temp = queue.poll(); // 그 다음 카드 꺼내서
            queue.add(temp); // 맨 뒤로 보내기
        }

        // 마지막 남은 카드 출력
        System.out.println(queue.poll());

        sc.close(); // 스캐너 닫기
    }
}
