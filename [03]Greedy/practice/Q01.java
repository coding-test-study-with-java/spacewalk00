package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//거스름돈 예제 3-1
public class Q01 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int[] coin_types = {500, 100, 50, 10};
        
        for(int coin : coin_types) { 
            cnt += N / coin;
            N %= coin;
        }
        
        System.out.println(cnt);
    }
}