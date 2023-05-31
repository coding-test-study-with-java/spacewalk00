import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q4_4 {
    public static int d;
    
    public static void turn_left() {
        d -= 1;
        if(d == -1) {
            d = 3;
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st2.nextToken());
        int y = Integer.parseInt(st2.nextToken());
        d = Integer.parseInt(st2.nextToken());
        
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st3.nextToken());
            }
        }
        
        //방문한 위치를 저장하기 위한 배열 초기화
        int[][] foot = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                foot[i][j] = 0;
            }   
        }
        //북 동 남 서
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        int next_x, next_y;
        int count = 1; //현재 위치도 방문한 칸의 수에 포함해야 함
        int turn_time = 0;
        
        while(true) {
            turn_left(); //회전
            next_x = x + dx[d];
            next_y = y + dy[d];
            
            //전진할 곳이 가보지 않은 곳이면서, 육지
            if(foot[next_x][next_y] == 0 && map[next_x][next_y] == 0) {
                count++;
                
                foot[next_x][next_y] = 1;
                x = next_x;
                y = next_y;
                turn_time = 0;
                continue;
            }
            else {
                //가본곳이면서, 바다임
                turn_time += 1;
            }
            
            //네 방향 전부 전진할 수 없을 때!
            if(turn_time == 4) {
                next_x = x - dx[d]; //후진
                next_y = y - dy[d];
                
                //후진가능하다면
                if(foot[next_x][next_y] == 0) {
                    x = next_x;
                    y = next_y;
                }
                else {
                    break;
                }
                turn_time = 0;
            }
        }
        System.out.println(count);
    }
}