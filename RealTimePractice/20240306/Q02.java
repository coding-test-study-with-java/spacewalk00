/**
 * [점프]
 * https://www.acmicpc.net/problem/1890
 */

import java.io.*;
import java.util.*;

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int x = 0, y = 0;
        
        
        //경로의 개수 dp
        //다음으로 도착하게 되는 이동칸에 이전 칸까지 오는 경로의 개수를 더함.
        
        //1. dp[i+map[i][j]][j] = dp[i+map[i][j]][j] + dp[i][j] 아래
        //2. dp[i][j+map[i][j]] = dp[i][j+map[i][j]] + dp[i][j] 오
        
        //종점일때 멈추기
        //map 바깥으로 넘어가는거 처리
        
        long dp[][] = new long[N][N]; //경로개수(263-1보다 작거나 같다.)
        dp[0][0] = 1;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int next = map[i][j];
                
                if(next == 0) {
                    break;
                }
                
                if(i+next < N) {
                    dp[i+next][j] += dp[i][j];
                }
                
                if(j+next < N) {
                    dp[i][j+next] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
    
}