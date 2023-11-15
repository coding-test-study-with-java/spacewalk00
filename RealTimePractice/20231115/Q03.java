/**
 * 두 동전 [미완] 
 * 익숙한 문제였으나(재귀라는 거 앎) 여전히 못푸는 문제.?
 * https://www.acmicpc.net/problem/16197
 */
import java.util.*;
import java.io.*;

public class MyClass {
    
    static int[] dx = {0, 0, -1, 1}; //상하좌우
    static int[] dy = {1, -1, 0, 0};
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
        
        move(new TwoCoinLoc(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1]), 0);
        
        //int coin1_r = coins.get(0)[0]; int coin1_c = coins.get(0)[1];
        //int coin2_r = coins.get(1)[0]; int coin2_c = coins.get(1)[1];
        
    }
    static public void move(TwoCoinLoc TwoCoinLoc, int btnCnt) {
        if(btnCnt >= 10) {
            return;
        }

        for(int i=0; i<4; i++) {
            int outCnt = 0; 

            int next1_r = coins.get(0)[0] + dx[i];
            int next1_c = coins.get(0)[1] + dy[i];
            int next2_r = coins.get(1)[0] + dx[i];
            int next2_c = coins.get(1)[1] + dy[i];

            if(next1_r < 0 || next1_r >= M || next1_c < 0 || next1_c >= N) {
                outCnt++;
            }
            if(next2_r < 0 || next2_r >= M || next2_c < 0 || next2_c >= N) {
                outCnt++;
            }

            if(outCnt == 2) {
                continue; 
            }
            if(outCnt == 1) {
                count = Math.min(count, btnCnt + 1);
                return;
            }

            if(board[next1_c][next1_r] == -1) { //벽
                next1_c = coins.get(0)[0];
                next1_r = coins.get(0)[1];
            }
            if(board[next2_c][next2_r] == -1) {
                next2_c = coins.get(0)[0];
                next2_r = coins.get(0)[1];
            }

            move(new TwoCoinLoc(next1_r, next1_c, next2_r, next2_c), btnCnt + 1);
        }
    }

    static class TwoCoinLoc {
        int now1_r;
        int now1_c;
        int now2_r;
        int now2_c;
        
        TwoCoinLoc(int now1_r, int now1_c, int now2_r, int now2_c) {
            this.now1_r = now1_r;
            this.now1_c = now1_c;
            this.now2_r = now2_r;
            this.now2_c = now2_c;
        }
    }


}