package week10;
/*이진수 합*/
import java.io.*;
import java.math.BigInteger;
public class num8741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // 2^k
        BigInteger two = new BigInteger("2");
        BigInteger pow = two.pow(k);

        // sum = (2^k * (2^k - 1)) / 2
        BigInteger sum = pow.multiply(pow.subtract(BigInteger.ONE)).divide(BigInteger.TWO);

        // 이진수로 출력
        System.out.println(sum.toString(2));
    }
}
