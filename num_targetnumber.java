import java.util.*;

public class num_targetnumber{
    static int target, count = 0;
    static int[] numbers;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        target = sc.nextInt();
        sc.close();
        
        dfs(0, 0);
        System.out.println(count);
    }
    
    static void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) count++;
            return;
        }
        /*놓친 부분  */
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
