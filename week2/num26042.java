/* 식당 입구 대기 줄 -큐*/
import java.util.*;

public class num26042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정보 개수

        Queue<Integer> queue = new LinkedList<>();

        int maxSize = 0;
        int lastStudentAtMax = -1;

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int student = sc.nextInt();
                queue.offer(student); // 뒤에 줄 서기

                int size = queue.size();
                int last = student;

                // 최대 갱신 조건
                if (size > maxSize) {
                    maxSize = size;
                    lastStudentAtMax = last;
                } else if (size == maxSize) {
                    lastStudentAtMax = Math.min(lastStudentAtMax, last);
                }
            } else if (type == 2) {
                queue.poll(); // 앞에서 식사 시작
            }
        }

        System.out.println(maxSize + " " + lastStudentAtMax);
    }
}
