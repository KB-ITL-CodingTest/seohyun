package week13;


/*맹세- 내문제*/

import java.util.*;

public class num3407{
    static Set<String> elements = new HashSet<>();
    static boolean found;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initElements();

        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String s = sc.nextLine().toLowerCase();
            found = false;
            visited = new boolean[s.length() + 1]; // ✅ visited 추가
            brute(s, 0);
            System.out.println(found ? "YES" : "NO");
        }
    }

    static void brute(String s, int idx) {
        if (found || visited[idx]) return; // ✅ 메모이제이션

        if (idx == s.length()) {
            found = true;
            return;
        }

        visited[idx] = true;

        if (idx + 1 <= s.length()) {
            String one = s.substring(idx, idx + 1);
            if (elements.contains(one)) {
                brute(s, idx + 1);
            }
        }

        if (idx + 2 <= s.length()) {
            String two = s.substring(idx, idx + 2);
            if (elements.contains(two)) {
                brute(s, idx + 2);
            }
        }
    }

    static void initElements() {
        String[] raw = {
                "H","He","Li","Be","B","C","N","O","F","Ne",
                "Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca",
                "Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
                "Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr",
                "Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn",
                "Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd",
                "Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
                "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg",
                "Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th",
                "Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm",
                "Md","No","Lr", "Rf","Db","Sg","Bh","Hs","Mt","Ds",
                "Rg","Cn","Fl","Lv"
        };
        for (String e : raw) {
            elements.add(e.toLowerCase());
        }
    }
}
/*import java.io.*;
import java.util.*;

public class num3407 {
    static Set<String> elements = new HashSet<>();
    static boolean[] visited;
    static boolean found;

    public static void main(String[] args) throws IOException {
        initElements();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String word = br.readLine().trim().toLowerCase();
            visited = new boolean[word.length() + 1];
            found = false;
            dfs(word, 0);
            System.out.println(found ? "YES" : "NO");
        }
    }

    static void dfs(String word, int idx) {
        if (found) return;
        if (idx == word.length()) {
            found = true;
            return;
        }
        if (visited[idx]) return;

        visited[idx] = true;


        if (idx + 1 <= word.length()) {
            String one = word.substring(idx, idx + 1);
            if (elements.contains(one)) dfs(word, idx + 1);
        }


        if (idx + 2 <= word.length()) {
            String two = word.substring(idx, idx + 2);
            if (elements.contains(two)) dfs(word, idx + 2);
        }
    }

    static void initElements() {
        String[] raw = {
                "H","He","Li","Be","B","C","N","O","F","Ne",
                "Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca",
                "Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
                "Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr",
                "Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn",
                "Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd",
                "Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
                "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg",
                "Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th",
                "Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm",
                "Md","No","Lr", "Rf","Db","Sg","Bh","Hs","Mt","Ds",
                "Rg","Cn","Fl","Lv"
        };

        for (String s : raw) {
            elements.add(s.toLowerCase());
        }
    }
}*/

/*
import java.io.*;
import java.util.*;

public class num3407{
    static Set<String> elements = new HashSet<>();

    public static void main(String[] args) throws Exception {
        initElements();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim().toLowerCase();
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                if (!dp[i]) continue;

                if (i + 1 <= n && elements.contains(s.substring(i, i + 1))) {
                    dp[i + 1] = true;
                }
                if (i + 2 <= n && elements.contains(s.substring(i, i + 2))) {
                    dp[i + 2] = true;
                }
            }

            System.out.println(dp[n] ? "YES" : "NO");
        }
    }

    static void initElements() {
        String[] arr = {
                "H","He","Li","Be","B","C","N","O","F","Ne",
                "Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca",
                "Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
                "Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr",
                "Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn",
                "Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd",
                "Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
                "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg",
                "Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th",
                "Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm",
                "Md","No","Lr", "Rf","Db","Sg","Bh","Hs","Mt","Ds",
                "Rg","Cn","Fl","Lv"
        };
        for (String e : arr) {
            elements.add(e.toLowerCase());
        }
    }
}

*/

/*

public class num3407{
    static Set<String> elements = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initElements();  // 원소 기호 초기화

        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String s = sc.nextLine().toLowerCase();
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                if (!dp[i]) continue;

                // 1글자
                if (i + 1 <= n && elements.contains(s.substring(i, i + 1))) {
                    dp[i + 1] = true;
                }
                // 2글자
                if (i + 2 <= n && elements.contains(s.substring(i, i + 2))) {
                    dp[i + 2] = true;
                }
            }

            System.out.println(dp[n] ? "YES" : "NO");
        }
    }

    // 📘 원소 기호를 모두 소문자 형태로 저장
    static void initElements() {
        String[] arr = {
                 "H","He","Li","Be","B","C","N","O","F","Ne",
                "Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca",
                "Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
                "Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr",
                "Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn",
                "Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd",
                "Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
                "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg",
                "Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th",
                "Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm",
                "Md","No","Lr", "Rf","Db","Sg","Bh","Hs","Mt","Ds",
                "Rg","Cn","Fl","Lv"
        };
        for (String e : arr) {
            elements.add(e.toLowerCase());
        }
    }
}
*/



/*

public class num3407  {
    static Set<String> elements = new HashSet<>();
    static boolean[] dp;
    static int len;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원소 집합 초기화
        initElements();

        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {
            String word = sc.nextLine().toLowerCase(); // 소문자 처리
            len = word.length();
            dp = new boolean[len + 1];
            dp[0] = true; // 시작점

            for (int i = 0; i < len; i++) {
                if (!dp[i]) continue;

                // 1글자 원소
                if (i + 1 <= len) {
                    String one = word.substring(i, i + 1);
                    if (elements.contains(one)) dp[i + 1] = true;
                }

                // 2글자 원소
                if (i + 2 <= len) {
                    String two = word.substring(i, i + 2);
                    if (elements.contains(two)) dp[i + 2] = true;
                }
            }

            System.out.println(dp[len] ? "YES" : "NO");
        }
    }

    // 원소 집합 초기화 (소문자로 저장)
    static void initElements() {
        String[] raw = {
                "H","He","Li","Be","B","C","N","O","F","Ne",
                "Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca",
                "Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
                "Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr",
                "Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn",
                "Sb","Te","I","Xe","Cs","Ba","La","Ce","Pr","Nd",
                "Pm","Sm","Eu","Gd","Tb","Dy","Ho","Er","Tm","Yb",
                "Lu","Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg",
                "Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Ac","Th",
                "Pa","U","Np","Pu","Am","Cm","Bk","Cf","Es","Fm",
                "Md","No","Lr", "Rf","Db","Sg","Bh","Hs","Mt","Ds",
                "Rg","Cn","Fl","Lv"
        };

        for (String e : raw) {
            elements.add(e.toLowerCase());
        }
    }
}
*/
