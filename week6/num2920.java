package week6;
import java.util.Scanner;

/*구현-음계*/
public class num2920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sub = 0;
        int[] a = new int[8];
        for (int i = 0; i < 8; i++) {
            a[i] = sc.nextInt();
        }
/*boolean으로 사용하면 더 편함*/
        boolean Ascending = true;
        boolean Descending = true;

        for (int i = 0; i < 7; i++) {
            if (a[i] < a[i + 1]) {
                Descending = false;
            } else if (a[i] > a[i + 1]) {
                Ascending = false;
            }
        }

            if (Ascending) {
                System.out.println("ascending");
            } else if (Descending) {
                System.out.println("descending");
            } else {
                System.out.println("mixed");
            }
        }
    }
