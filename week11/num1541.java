package week11;


/*잃어버린 괄호*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class num1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();   // 수식 전체

        // 1) '-' 로 분리
        String[] minusParts = expr.split("-");

        int answer = 0;

        // 2) 첫 부분(첫 '-' 이전)은 그대로 더함
        answer += sumOfPart(minusParts[0]);

        // 3) 이후 부분은 각각 합을 구해 한꺼번에 빼기
        for (int i = 1; i < minusParts.length; i++) {
            answer -= sumOfPart(minusParts[i]);
        }

        System.out.println(answer);
    }

    // "a+b+c" 형태 문자열의 합을 계산
    private static int sumOfPart(String part) {
        String[] plusParts = part.split("\\+");
        int sum = 0;
        for (String numStr : plusParts) {
            sum += Integer.parseInt(numStr);
        }
        return sum;
    }
}
