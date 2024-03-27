/**
 * 사과 담기 게임
 * https://www.acmicpc.net/problem/2828
 */
import java.io.*;
import java.util.*;

public class MyClass {
    
    public static void main(String args[]) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  
		int M = Integer.parseInt(st.nextToken());  
		int apple = Integer.parseInt(br.readLine());
		
		int left = 1; //바구니 왼쪽 좌표
		int right = M; //바구니 오른쪽 좌표
		int cnt = 0; 
		
		for(int i=0; i<apple; i++) {
			int where = Integer.parseInt(br.readLine());
			
			if(left <= where && where <= right) { //바구니 안
				continue;
			}
			
			if(left > where) { //왼쪽에 가까울때
				cnt += (left-where);
				right -= (left-where);
				left = where;
			} else { //오른쪽에 가까울 때
				cnt += (where-right);
				left += (where-right);
				right = where;
			}
		}
		
		System.out.println(cnt);
        
    }
    
}