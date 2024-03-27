/*
 * 스타트링크
 * https://www.acmicpc.net/problem/5014
 * 
 * 
 * DFS로 하면 시간 초과 !!! 
 * 최단 거리는 BFS가 유리함.......... 
 * 
 * BFS : Queue자료형(비울때까지 반복) + 방문한 곳 체크 
 */
import java.io.*;
import java.util.*;

public class MyClass {
    
    static int F, S, G;
    static int[] move; //클릭한 횟수 저장하기
    static int[] updown = new int[2];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        
        updown[0] = Integer.parseInt(st.nextToken());
        updown[1] = (-1) * Integer.parseInt(st.nextToken());
        
        move = new int[F+1]; //1~F층
        bfs(S);
    }
    
    static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] visited = new boolean[F+1];
        
        q.add(s);
        visited[s] = true;
        move[s] = 0;
        
        while(!q.isEmpty()) {
            int floor = q.poll();
            
            if(floor == G) {
                System.out.println(move[floor]);
                return;
            }
            
            for(int i=0; i<2; i++) {
                int next = floor + updown[i];
                
                if(next > F || next < 1) {
                    continue;
                }
                
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    move[next] = move[floor] + 1;
                }
            }
        }
        
        System.out.println("use the stairs");
    }
    
    
}