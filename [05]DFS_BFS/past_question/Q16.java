import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;

/* 
백준 골드 5 - 연구소
- N 제한이 8 (매우 작은 수)
- 3개의 벽을 세우는 모든 경우의 수 = DFS (이유: 칸이 빈칸인지 확인해야 함)
- 벽을 만들고 바이러스를 퍼트리는 과정 = BFS  (이유: 인접한 다른 정점으로 이동할 때 1의 가중치)
*/
public class Q16 {
    public static final int dx[] = {0, 0, 1, -1}; //상하좌우 방향
    public static final int dy[] = {1, -1, 0, 0};
    
    public static int N, M;
    public static int[][] room;
    public static int maxSafeZone = Integer.MIN_VALUE; 
    
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        
        room = new int[N][M];
        for(int i=0; i<N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                room[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);
    }
    
    public static void dfs(int wallCnt) {
        if(wallCnt == 3) {
            bfs();
            return;
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(room[i][j] == 0) {
                    room[i][j] = 1; //벽 세우기
                    dfs(wallCnt+1);
                    room[i][j] = 0; //원 위치
                }
            }
        }
    }
    
    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(room[i][j] == 2) {
                    q.offer(new Node(i, j));
                }
            }
        }
        
        //원본 연구소의 카피본
        int copyRoom[][] = new int[N][M];
        for(int i=0; i<N; i++) {
            copyRoom[i] = room[i].clone();
        }
        
        //BFS 탐색
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x; //현재
            int y = now.y;
            
            for(int k=0; k<4; k++) { //상하좌우
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && copyRoom[nx][ny] == 0) { //연구소 밖x
                    q.offer(new Node(nx, ny));
                    copyRoom[nx][ny] = 2;
                }
            }
        }        
        checkSafeZone(copyRoom);
    }
    
    public static void checkSafeZone(int[][] copyRoom) {
        int safeZone = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyRoom[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}