import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

//미로탈출 p.152 //아직 못품.
public class Q5_2 {
    //x, y의 정보를 담을 Point 클래스   
    static class Point {
        public int x;
        public int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point() {
            x = -1;
            y = -1;
        }
        
        @Override
        public String toString() {
            return (x + " " + y);
        }
    }
    
    public static int[][] maze;
    public static int N, M;
    
    public static int[] dx = {-1, 1, 0, 0}; //상하좌우
    public static int[] dy = {0, 0, -1, 1};
    
    //bfs 현재 위치에서 가까운 노드부터~
    public static int bfs(Point point) { 
        Queue<Point> queue = new LinkedList<>();
        int count = 1;
        queue.offer(point);
            
        //maze[point.x][point.y] = 0; //방문
        
        while(queue.isEmpty() == false) {
            System.out.println("맨 앞에 있는 값값"+queue.peek().toString());
            Point p = queue.poll();
            System.out.println(p.toString());
            
            if(p != null) {
                maze[p.x][p.y] = 0; //방문
                System.out.println("현재 방문중인곳"+p.x+" "+p.y);
                Point n_p = new Point();
                for(int i=0; i<4; i++) { //상하좌우 전부 확인
                    n_p.x = p.x + dx[i];
                    n_p.y = p.y + dy[i];
                    if (n_p.x < 0 || n_p.x >= N || n_p.y < 0 || n_p.y >= M) { //미로 벗어나면
                        System.out.println("미로에서 벗어난 값"+n_p.toString());
				    }
				    else {
				        if(maze[n_p.x][n_p.y] == 1) {
                            System.out.println("괴물이 없는 곳으로"+n_p.toString());
				            if (n_p.x > p.x || n_p.y > p.y) {//괴물 없는길이면서, 최단경로로!
				                count++;
                                System.out.println("큐에 들어간 값"+n_p.toString());
				                queue.offer(n_p);
				            }
				        }
				    }
                    if(queue.peek() != null) {
				        System.out.println(i+"여기서 젤 앞에 있는 값은?"+queue.peek().toString());
                    }
                }
            }
        }
        
        return count;
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
              System.out.print(maze[i][j]);
           }
           System.out.println();
        }
        
        Point point = new Point(0, 0);
        int result = bfs(point);
        
        System.out.println(result);
    }
}