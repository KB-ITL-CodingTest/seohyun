package week13;

/*큰 수 계산*/
import java.util.*;

public class num2408 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = Integer.parseInt(sc.nextLine());
            String result = sc.nextLine();

            for (int i = 1; i < N; i++) {
                String op = sc.nextLine();
                String num = sc.nextLine();

                switch (op) {
                    case "+":
                        result = add(result, num);
                        break;
                    case "-":
                        result = subtract(result, num);
                        break;
                    case "*":
                        result = multiply(result, num);
                        break;
                    case "/":
                        result = divide(result, num);
                        break;
                }
            }

            System.out.println(result);
        }

        // 부호 포함 정수 덧셈
        public static String add(String a, String b) {
            if (a.charAt(0) != '-' && b.charAt(0) != '-') {
                return addAbs(a, b);
            } else if (a.charAt(0) == '-' && b.charAt(0) == '-') {
                return "-" + addAbs(a.substring(1), b.substring(1));
            } else if (a.charAt(0) == '-') {
                return subtract(b, a.substring(1));
            } else {
                return subtract(a, b.substring(1));
            }
        }

        // 부호 포함 정수 뺄셈
        public static String subtract(String a, String b) {
            if (a.charAt(0) != '-' && b.charAt(0) != '-') {
                if (compareAbs(a, b) >= 0)
                    return subtractAbs(a, b);
                else
                    return "-" + subtractAbs(b, a);
            } else if (a.charAt(0) == '-' && b.charAt(0) == '-') {
                return subtract(b.substring(1), a.substring(1));
            } else if (a.charAt(0) == '-') {
                return "-" + addAbs(a.substring(1), b);
            } else {
                return addAbs(a, b.substring(1));
            }
        }

        // 부호 포함 정수 곱셈
        public static String multiply(String a, String b) {
            boolean negative = false;
            if (a.charAt(0) == '-') {
                negative = !negative;
                a = a.substring(1);
            }
            if (b.charAt(0) == '-') {
                negative = !negative;
                b = b.substring(1);
            }

            String res = multiplyAbs(a, b);
            if (res.equals("0")) return "0";
            return negative ? "-" + res : res;
        }

        // 부호 포함 정수 나눗셈 (내림)
        public static String divide(String a, String b) {
            boolean negative = false;
            if (a.charAt(0) == '-') {
                negative = !negative;
                a = a.substring(1);
            }
            if (b.charAt(0) == '-') {
                negative = !negative;
                b = b.substring(1);
            }

            String q = divideAbs(a, b);
            if (q.equals("0")) return "0";

            // 내림 보정
            String mod = modAbs(a, b);
            if (!mod.equals("0") && negative) {
                q = addAbs(q, "1");
                return "-" + q;
            }

            return negative ? "-" + q : q;
        }

        // ========== 아래는 절댓값 연산 ==========
        public static String addAbs(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int i = a.length() - 1, j = b.length() - 1;

            while (i >= 0 || j >= 0 || carry > 0) {
                int x = i >= 0 ? a.charAt(i--) - '0' : 0;
                int y = j >= 0 ? b.charAt(j--) - '0' : 0;
                int sum = x + y + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }

            return sb.reverse().toString();
        }

        public static String subtractAbs(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1;
            int borrow = 0;

            while (i >= 0) {
                int x = a.charAt(i--) - '0';
                int y = j >= 0 ? b.charAt(j--) - '0' : 0;
                x -= borrow;

                if (x < y) {
                    x += 10;
                    borrow = 1;
                } else {
                    borrow = 0;
                }

                sb.append(x - y);
            }

            // remove leading zeros
            while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }

            return sb.reverse().toString();
        }

        public static String multiplyAbs(String a, String b) {
            int[] res = new int[a.length() + b.length()];
            for (int i = a.length() - 1; i >= 0; i--) {
                for (int j = b.length() - 1; j >= 0; j--) {
                    int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                    int sum = res[i + j + 1] + mul;
                    res[i + j] += sum / 10;
                    res[i + j + 1] = sum % 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int val : res) {
                if (sb.length() != 0 || val != 0) sb.append(val);
            }

            return sb.length() == 0 ? "0" : sb.toString();
        }

        public static String divideAbs(String a, String b) {
            if (compareAbs(a, b) < 0) return "0";

            StringBuilder result = new StringBuilder();
            String current = "";

            for (int i = 0; i < a.length(); i++) {
                current += a.charAt(i);
                current = trimLeadingZeros(current);
                int count = 0;
                while (compareAbs(current, b) >= 0) {
                    current = subtractAbs(current, b);
                    count++;
                }
                result.append(count);
            }

            return trimLeadingZeros(result.toString());
        }

        public static String modAbs(String a, String b) {
            if (compareAbs(a, b) < 0) return a;

            String current = "";

            for (int i = 0; i < a.length(); i++) {
                current += a.charAt(i);
                current = trimLeadingZeros(current);
                while (compareAbs(current, b) >= 0) {
                    current = subtractAbs(current, b);
                }
            }

            return trimLeadingZeros(current);
        }

        public static int compareAbs(String a, String b) {
            a = trimLeadingZeros(a);
            b = trimLeadingZeros(b);
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        }

        public static String trimLeadingZeros(String s) {
            int i = 0;
            while (i < s.length() - 1 && s.charAt(i) == '0') i++;
            return s.substring(i);
        }
    }
