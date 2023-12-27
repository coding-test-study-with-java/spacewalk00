/**
 * 두 동전 
 * https://www.acmicpc.net/problem/16197
 */
import java.util.*;
import java.io.*;

/*
[BFS]
bfs는 두 노드 사이의 최단 경로나 임의의 경로를 찾고 싶을 때 사용
인접리스트O(N+E), 인접행렬O(N^2)

어떤 노드를 방문했었는지 여부를 검사하지 않는다면 무한 루프 상태에 빠짐.
방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 큐를 사용한다. (선입선출의 원칙)
프림과 다익스트라 알고리즘과 유사. 
재귀X

[DFS]
dfs는 하나의 정점으로부터 차례대로 모든 정점들을 한번씩 방문하는 것. (모든 노드를 방문하고자 하는 경우 사용)
인접리스트O(N+E), 인접행렬O(N^2)

어떤 노드를 방문했었는지 여부를 검사하지 않는다면 무한 루프 상태에 빠짐.
루트 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법
검색 속도는 bfs에 비해서 느림
재귀O, 전위 순회 역시 dfs의 한 종류

[Backtracking]
dfs와 분리하기 어려운 개념. 굳이 분리하면 끝까지 가느냐 돌아오냐의 차이
백트래킹은 현재 가는 길이 더 이상의 해가 아니라고 판단되면 되돌아오는 것을 의미함.
이것을 가지치기라고 부름 (즉, 불필요한 경로는 굳이 끝까지 탐색하지 않겠다는 뜻)
대표적인 문제는 '순열/조합', 'N-Queen', '배낭문제' 등의 유형이 있음.
*/

//이 문제에서는 BFS 방식보다 Backtracking이 사용하기 쉬웠음.
//x, y 방향과 이차원 배열 속 j, x를 연결시키지 못하면 어려운 문제

public class MyClass {
    
    static int[] dx = {0, 0, -1, 1}; //좌우상하
    static int[] dy = {-1, 1, 0, 0};
    
    static char[][] map;
    static int N, M;
    static int count = Integer.MAX_VALUE;
    
    static int x1, x2, y1, y2;
    static boolean getFirst;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
    
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'o') {
                    if(getFirst) {
                        y2 = i;
                        x2 = j;
                    } else {
                        y1 = i;
                        x1 = j;
                        getFirst = true;
                    }
                }
                
            }
        }
        pushBtn(new TwoCoinLoc(y1, x1, y2, x2), 0);
        
        if(count == Integer.MAX_VALUE) { //
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
    static public void pushBtn(TwoCoinLoc twoCoinLoc, int btnCnt) {
        if(btnCnt >= count || btnCnt >= 10) { //10회 이상 누르면 종료하는 조건
            return;
        }

        for(int i=0; i<4; i++) {
            int outCnt = 0; 

            int next1_x = twoCoinLoc.x1 + dx[i];
            int next1_y = twoCoinLoc.y1 + dy[i];
            
            int next2_x = twoCoinLoc.x2 + dx[i];
            int next2_y = twoCoinLoc.y2 + dy[i];

            if(next1_y < 0 || next1_y >= N || next1_x < 0 || next1_x >= M) {
                outCnt++;
            }
            if(next2_y < 0 || next2_y >= N || next2_x < 0 || next2_x >= M) {
                outCnt++;
            }

            if(outCnt == 2) {
                continue; 
            }
            if(outCnt == 1) { // 두 동전 중 하나만 빠져나갔는지 체크하고, 최소 카운팅
                count = Math.min(count, btnCnt + 1);
                return;
            }

            if(map[next1_y][next1_x] == '#') { //벽이면 그 자리에 멈추기
                next1_x = twoCoinLoc.x1;
                next1_y = twoCoinLoc.y1;
            }
            if(map[next2_y][next2_x] == '#') {
                next2_x = twoCoinLoc.x2;
                next2_y = twoCoinLoc.y2;
            }

            pushBtn(new TwoCoinLoc(next1_y, next1_x, next2_y, next2_x), btnCnt + 1); //조건 모두 통과하면 백트래킹 진행
        }
    }

    static class TwoCoinLoc {
        int y1;
        int x1;
        int y2;
        int x2;
        
        TwoCoinLoc(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
        }
    }
}
/*
[이전 풀이]
import java.util.*;
import java.io.*;

public class MyClass {
    
    static int[] dx = {0, 0, -1, 1}; //상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[][] board;
    static List<int[]> coins;
    static int N, M;
    static int count = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
    
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        board = new int[N][M];
        coins = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            String[] str2 = br.readLine().split("");
            for(int j=0; j<M; j++) {
                if(str2[j].equals("o")) {
                    board[i][j] = 1;
                    int[] temp = {i, j};
                    coins.add(temp); 
                } else if (str2[j].equals(".")) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = -1;
                }
            }
        }
        
        pushBtn(new TwoCoinLoc(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1]), 0);
        
        System.out.println(count);
        //int coin1_x = coins.get(0)[0]; int coin1_y = coins.get(0)[1];
        //int coin2_x = coins.get(1)[0]; int coin2_y = coins.get(1)[1];
        
    }
    static public void pushBtn(TwoCoinLoc TwoCoinLoc, int btnCnt) {
        if(btnCnt >= 10) {
            return;
        }

        for(int i=0; i<4; i++) {
            int outCnt = 0; 

            int next1_x = coins.get(0)[0] + dx[i];
            int next1_y = coins.get(0)[1] + dy[i];
            
            int next2_x = coins.get(1)[0] + dx[i];
            int next2_y = coins.get(1)[1] + dy[i];

            if(next1_y < 0 || next1_y >= N || next1_x < 0 || next1_x >= M) {
                outCnt++;
            }
            if(next2_y < 0 || next2_y >= N || next2_x < 0 || next2_x >= M) {
                outCnt++;
            }

            if(outCnt == 2) {
                continue; 
            }
            if(outCnt == 1) {
                count = Math.min(count, btnCnt + 1);
                return;
            }

            if(board[next1_x][next1_y] == -1) { //벽
                next1_x = coins.get(0)[0];
                next1_y = coins.get(0)[1];
            }
            if(board[next2_x][next2_y] == -1) {
                next2_x = coins.get(0)[0];
                next2_y = coins.get(0)[1];
            }

            pushBtn(new TwoCoinLoc(next1_x, next1_y, next2_x, next2_y), btnCnt + 1);
        }
    }

    static class TwoCoinLoc {
        int now1_x;
        int now1_y;
        int now2_x;
        int now2_y;
        
        TwoCoinLoc(int now1_x, int now1_y, int now2_x, int now2_y) {
            this.now1_x = now1_x;
            this.now1_y = now1_y;
            this.now2_x = now2_x;
            this.now2_y = now2_y;
        }
    }


}*/