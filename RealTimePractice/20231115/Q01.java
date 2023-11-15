/**
 * 마법사 상어와 비바라기 [미완]
 * https://www.acmicpc.net/problem/21610
 * 구름 이동 시키는 법 연구해야함. .....
 */
import java.util.*;
import java.io.*;

public class MyClass {
    
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}
    static int[] dy = {0, -1, 1, 1, 0, -1, -1, -1}
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        
        int[][] area = new int[N][N];
        int[][] cloudInfo = new int[N][N]; //0:구름x, 1: 구름o
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                cloudInfo[i][j] = 0;
            }
        }
        
        List<int[]> moveCloudInfo = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String[] str2 = br.readLine().split(" ");
            int d = Integer.parseInt(str2[0]);
            int s = Integer.parseInt(str2[1]);
            int[] temp = {d, s};
            moveCloudInfo.add(temp);
        }
        //구름 첫 위치 초기화.
        cloudInfo[N-1][0] = 0;
        cloudInfo[N-1][1] = 0;
        cloudInfo[N-2][0] = 0;
        cloudInfo[N-2][1] = 0;
        /*cloudInfo[N][1] 
        cloudInfo[N][2]
        cloudInfo[N-1][1]
        cloudInfo[N-1][2]*/
        
        for(int[] move : moveCloudInfo) {
            // * move[1] 구름 이동
            for(int i=0; i<move[1]; i++) {
                
            }
            
            dx[move[0]-1]
            dy[move[0]-1]
        }
        
        
        
        
        
    }
}
