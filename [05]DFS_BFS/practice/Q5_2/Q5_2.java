package Q5_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

//미로탈출 p.152 
//왜....왜...대체왜....~?
public class Q5_2 {  
    public static int[][] maze;
    public static int N, M;
    
    public static int[] dx = {-1, 1, 0, 0}; //상하좌우
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Point> queue = new LinkedList<>();
    
    //bfs 현재 위치에서 가까운 노드부터~
    public static int bfs(int x, int y) { //객체로 넘어올때.. 오류났었음..!
        queue.offer(new Point(x, y));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            x = p.x;
            y = p.y;
            
            for(int i=0; i<4; i++) { //상하좌우 전부 확인
                int nx = x + dx[i];
                int ny = y + dy[i];
                //미로 벗어나면
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) { 
                    continue;
                }
                //괴물인 경우
                if (maze[nx][ny] == 0) {
                    continue;
                }
                if(maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }        
        return maze[N-1][M-1];
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        
        maze = new int[N][M];
        for(int i=0; i<N; i++) {
           String[] row = br.readLine().split("");
           for(int j=0; j<M; j++) {
              maze[i][j] = Integer.parseInt(row[j]);
           }
        }
        br.close();                
        System.out.print(bfs(0, 0));
    }
}