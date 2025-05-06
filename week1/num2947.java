package week1;/* 1697번 -나무조각- 브론즈1 */

import java.util.Scanner;

public class num2947{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		// 두 변수의 값을 교환(swap)할 때 중간 저장 공간이 필요하기 때문<temp를 사용하는 이유>
		int temp = 0;
		boolean finish;
		do {
			finish = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i]; // arr[i]값을 temp에 임시 저장
					arr[i] = arr[i + 1]; // 덮어쓰기
					arr[i + 1] = temp; // temp=arr[i]; 여기에서 덮어 쓴 것을 다시 쓰는 것
					finish = true;

					System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4]);
				}
			}

		} while (finish);
		sc.close();
	}

}
