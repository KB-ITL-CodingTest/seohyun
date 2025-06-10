package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*가장 많은 글자*/
public class num1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] freq = new int[26];          // 각 알파벳 빈도
        String line;

        // EOF까지 한 줄씩 읽어 처리
        while ((line = br.readLine()) != null) {
            for (char ch : line.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    freq[ch - 'a']++;
                }
            }
        }

        // 최대 빈도 계산
        int max = 0;
        for (int f : freq) {
            if (f > max) max = f;
        }

        // 최대 빈도를 가진 문자들을 알파벳 순으로 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == max) {
                sb.append((char) ('a' + i));
            }
        }
        System.out.println(sb.toString());
    }
}
