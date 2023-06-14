import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

//음료수얼려먹기 p.149
public class Q5_1 {
    //방문한 노드를 그래프에 반영하기 위해서(0->1) 전역변수로
    public static int N;
    public static int M;
    public static int[][] container;
    
    //dfs, 상하좌우 움직일 수 있게
    public static boolean dfs(int r, int c) { //현재 위치 좌표
        if(r < 0 || r >= N || c < 0 || c >= M) {
            return false;
        }
        else {
            if(container[r][c] == 0) { //구멍 O
                container[r][c] = 1; //방문한 노드 1로 변경
                dfs(r+1, c);
                dfs(r-1, c);
                dfs(r, c-1);
                dfs(r, c+1);
                return true;
            }
            return false;
        }
    }
    
    public static void main(String args[]) throws IOException {
        // 입력 (공백없는 입력시 split("") 활용가능)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        
        container = new int[N][M];
        for(int i=0; i<N; i++) {
           String[] row = br.readLine().split("");
           for(int j=0; j<M; j++) {
              container[i][j] = Integer.parseInt(row[j]);
           }
        }
        
        //덩어리 하나씩 계산
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(dfs(i,j) == true) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}