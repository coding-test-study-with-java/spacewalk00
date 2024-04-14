/**
 * 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 */

import java.util.*;
import java.io.*;

public class MyClass {
    static int cnt = 1; //청소 칸 수 (첫 칸은 무조건 청소)
    static int N = 0, M = 0; //NXM
    static int[][] map; //map
    static boolean[][] visited;
    
    static int dy[] = {-1,0,1,0};  // 북동남서	d:0, 1, 2, 3
    static int dx[] = {0,1,0,-1};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] robot = new int[2]; //로봇의 위치
        int d = 0; //로봇의 방향
        
        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        st = new StringTokenizer(br.readLine());
        robot[0] = Integer.parseInt(st.nextToken()); //로봇 위치 y축 방향
        robot[1] = Integer.parseInt(st.nextToken()); //로봇 위치 x축 방향
        d = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
        //
        
        dfs(robot, d);
        System.out.println(cnt); //청소 횟수
    }
    
    static void dfs(int[] robot, int direction) {
        int[] next_robot = new int[2]; 
        
        visited[robot[0]][robot[1]] = true;
        
        //반시계로 회전하면서 청소할 곳 찾기
        for(int i=0; i<4; i++) {
            direction = (direction + 3) % 4; //이 부분.. 중요
            next_robot[0] = robot[0] + dy[direction];
            next_robot[1] = robot[1] + dx[direction];
            
            if(next_robot[0] >= 0 && next_robot[0] < N && next_robot[1] >= 0 && next_robot[1] < M && map[next_robot[0]][next_robot[1]] != 1 && !visited[next_robot[0]][next_robot[1]]) {
                //청소한적없고, map 안쪽, 벽 아닐때
                dfs(next_robot, direction);
                cnt++;
                visited[next_robot[0]][next_robot[1]] = true;
                return;
            }
        }
        
        //네 방향 모두 봤는데, 청소할 곳 없을 때 후진
        next_robot[0] = robot[0] + dy[(direction + 2) % 4];
        next_robot[1] = robot[1] + dx[(direction + 2) % 4];
        
        if(next_robot[0] >= 0 && next_robot[0] < N && next_robot[1] >= 0 && next_robot[1] < M && map[next_robot[0]][next_robot[1]] != 1) {
            //map 안쪽, 벽 아닐때
            dfs(next_robot, direction); //바라보는 방향 유지.
        }
    }
    
    
}