package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//숫자 카드 게임
public class Q03 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[r][c];
        int max = 0;
        for(int i=0; i<r; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int row_min = 10001;
            for(int j=0; j<c; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
                if(row_min > arr[i][j]) {
                    row_min = arr[i][j];
                }
            }
            if(max < row_min) {
                max = row_min;
            }
        }
        System.out.println(max);
    }
}
