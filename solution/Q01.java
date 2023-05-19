package week01_Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int[] scary = new int[n];		
		Integer[] scary_ver2 = new Integer[n];
		for(int i=0; i<n; i++) {
			scary[i] = sc.nextInt();
			scary_ver2[i] = scary[i];		
		}
		
		int cnt = 0;
		Arrays.sort(scary_ver2, Collections.reverseOrder()); // 내림차순 정렬
		
		for(int i=0; i<n; i++) { //최댓값 빼서 그룹수 카운트
			n -= scary_ver2[i]; 
			if(n >= 0) {
				cnt++;				
			} else {
				break;
			}
		}
		System.out.print(cnt);
		sc.close();		
	}

}
