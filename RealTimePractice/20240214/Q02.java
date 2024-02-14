/**
 * 스티커
 * https://www.acmicpc.net/problem/9465
 * 
 * test case는 맞았는데 틀림 뜸.
 */
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            
            int N = Integer.parseInt(br.readLine());
            
            int[][] weight = new int[2][N];
            int[][] dp = new int[2][N];
        
            for(int j=0; j<2; j++) {
                String[] str = br.readLine().split(" ");
                for(int k=0; k<N; k++) {
                    weight[j][k] = Integer.parseInt(str[k]);
                }
            }
            
            dp[0][0] = weight[0][0];
            dp[1][0] = weight[1][0];
            
            int max = Integer.MIN_VALUE;
            
            for(int j=1; j<N; j++) {
                if(j == 1) {
                    dp[0][j] = dp[1][0] + weight[0][1];
                    dp[1][j] = dp[0][0] + weight[1][1];
                    max = Math.max(dp[0][j], dp[1][j]); 
                    continue;
                }
                
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + weight[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + weight[1][j];
                max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
            }
            sb.append(max + "\n");

        }
        
        System.out.print(sb);
    }
    
}