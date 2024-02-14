/**
 * 다익스트라 알고리즘
 * [젤다 전설 게임]
 * https://www.acmicpc.net/problem/4485
 * 
 * 미완
 */
import java.util.*;
import java.io.*;

public class MyClass {
    public static class Node implements Comparable<Node> {
		int x;
		int y;
		int thief;
		
		public Node(int x, int y, int theif) {
			this.x = x;
			this.y = y;
			this.thief = thief;			
		}

		@Override
		public int compareTo(Node n) {
			return this.thief - n.thief;
		}
	}
    
    public static int N;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1}; //북동남서
    public static int[] dy = {1, 0, -1, 0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        while (N != 0) {
            cnt++;
            map = new int[N][N];
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    //값 더한게 최소인거..
                }

            }
            
            int result = search();
            System.out.println("Problem "+cnt+":"+ result);
            
            
            N = Integer.parseInt(br.readLine());
        }
    }
    
    
    public static int search() {
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[N][N];
        
        for(int i=0; i<N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        
        q.add(new Node(0, 0, map[0][0]));
        System.out.println(map[0][0]);
        visited[0][0] = map[0][0];
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            
            int x = n.x; int y = n.y;
            int thief = n.thief;
            
            if(x == N-1 && y == N-1) {
                return thief;
            }
            
            
            for(int i=0; i<4; i++) {
                int now_x = x + dx[i];
                int now_y = y + dy[i];
                
                //벽
                if(now_x < 0 || now_x > N-1 || now_y < 0 || now_y > N-1) {
                    continue;
                }
                
                //새로운 경로가 도둑루피가 더 적다면 갱신
                if(thief + map[now_y][now_x] < visited[now_y][now_x]) {
                    visited[now_y][now_x] = thief + map[now_y][now_x];
                    q.add(new Node(now_x, now_y, map[now_y][now_x]));
                }
                
            }
            
        }
        return -1;
    }
    
    
    
}